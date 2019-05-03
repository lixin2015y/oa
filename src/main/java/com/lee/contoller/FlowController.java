package com.lee.contoller;

import com.lee.common.ResponseMessage;
import com.lee.common.Result;
import com.lee.entity.Service;
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
        map.put("count", flowService.getCountService(user.getId(), title, urgent, flowTitle, status));
        return Result.success(map);
    }

    @PostMapping("getFlowToMe")
    ResponseMessage getFlowToMe() {

        return Result.success();
    }

    @PostMapping("putFlow")
    ResponseMessage putFlow() {
        return Result.success();
    }

}
