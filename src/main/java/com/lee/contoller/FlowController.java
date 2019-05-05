package com.lee.contoller;

import com.lee.common.ResponseMessage;
import com.lee.common.Result;
import com.lee.common.ZxException;
import com.lee.entity.Node;
import com.lee.entity.Service;
import com.lee.entity.ServiceVo;
import com.lee.entity.User;
import com.lee.model.HostHolder;
import com.lee.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RequestMapping("flow")
@RestController
public class FlowController {

    @Autowired
    HostHolder hostHolder;

    @Autowired
    FlowService flowService;

    @PostMapping("postFlow")
    ResponseMessage postFlow(Service service) {

        User user = hostHolder.getUser();
        service.setUserId(user.getId());
        service.setCreationtime(new Date());
        service.setStatus("待审批");
        try {
            flowService.apply(service);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.success();
    }

    @PostMapping("getMyFlow")
    ResponseMessage getMyLaunchFlow(Integer pageNum, Integer pageSize, String title, String urgent, String flowTitle, String status) {
        User user = hostHolder.getUser();
        List<Service> serviceList = flowService.getService(user, pageNum, pageSize, title, urgent, flowTitle, status);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("list", serviceList);
        map.put("count", flowService.getCountService(user, title, urgent, flowTitle, status));
        return Result.success(map);
    }

    @PostMapping("getFlowToMe")
    ResponseMessage getFlowToMe() {
        User user = hostHolder.getUser();
        List<Service> applyToMe = flowService.getApplyTome(user);
        return Result.success(applyToMe);
    }


    @PostMapping("approval")
    ResponseMessage approval(Integer processId, String status, Integer serviceId, Integer flowId) {

        try {
            flowService.approval(processId, status, serviceId, flowId);
        } catch (ZxException e) {
            e.printStackTrace();
            return Result.error("-1", e.getMessage());
        }
        return Result.success();
    }


    @PostMapping("getServiceMonitor")
    ResponseMessage getServiceMonitor(Integer pageNum, Integer pageSize, String title, String urgent, String flowTitle, String status) {
        List<ServiceVo> serviceList = flowService.getServiceMonitor(pageNum, pageSize, title, urgent, flowTitle, status);
        HashMap<Object, Object> map = new HashMap<>();
        for (ServiceVo serviceVo : serviceList) {
            switch (serviceVo.getStatus()) {
                case "待审批":
                case "审批通过":
                    //展示所有节点
                    List<Node> allNode = flowService.getAllNode(serviceVo.getFlowId());
                    StringBuilder nodeProcess = new StringBuilder();
                    for (Node node : allNode) {
                        nodeProcess.append(node.getName() + "->");
                    }
                    serviceVo.setNodeProcess(nodeProcess.toString());
                    break;
                case "已拒绝":
                case "审批中":
                    Node currentNode = flowService.getCurrentNode(serviceVo.getId());
                    serviceVo.setNodeProcess(currentNode.getName());
                    break;
                default:
                    return Result.error();
            }
        }
        map.put("list", serviceList);
        map.put("count", flowService.getCountServiceMonitor(title, urgent, flowTitle, status));
        return Result.success(map);
    }


}
