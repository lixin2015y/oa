package com.lee.service;

import com.lee.common.ZxException;
import com.lee.dao.FlowDao;
import com.lee.entity.Node;
import com.lee.entity.Process;
import com.lee.entity.User;
import org.assertj.core.error.ShouldBeInSameYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FlowService {

    @Autowired
    FlowDao flowDao;

    @Transactional
    public void apply(com.lee.entity.Service service) {
        //新建业务流程
        flowDao.insertService(service);
        //获取当前流程所有节点
        List<Node> nodes = flowDao.selectAllNode(service);
        //第一个节点入库
        Node node = nodes.get(0);
        Process process = new Process();
        process.setNodeId(node.getId());
        process.setServiceId(service.getId());
        process.setCreationtime(new Date());
        flowDao.insertProcess(process);

    }

    public List<com.lee.entity.Service> getService(User user, Integer pageNum, Integer pageSize, String title, String urgent, String flowTitle, String status) {
        return flowDao.selectService(user.getId(), pageSize * (pageNum - 1), pageSize, title, urgent, flowTitle, status);
    }

    public List<com.lee.entity.ServiceVo> getServiceMonitor(Integer pageNum, Integer pageSize, String title, String urgent, String flowTitle, String status) {
        return flowDao.selectServiceMonitor(pageSize * (pageNum - 1), pageSize, title, urgent, flowTitle, status);
    }

    public Integer getCountService(User user, String title, String urgent, String flowTitle, String status) {
        return flowDao.selectCountService(user.getId(), title, urgent, flowTitle, status);
    }

    public Integer getCountServiceMonitor(String title, String urgent, String flowTitle, String status) {
        return flowDao.selectCountServiceMonitor(title, urgent, flowTitle, status);
    }

    public List<com.lee.entity.Service> getApplyTome(User user) {
        return flowDao.selectApplyToMe(user.getId());
    }

    @Transactional
    public void approval(Integer processId, String status, Integer serviceId, Integer flowId) throws ZxException {
        switch (status) {
            case "1":
                //修改状态
                flowDao.updateServiceStatus(serviceId, "审批中");
                //更新进程
                flowDao.updateProcessStatus(processId, status);
                //拿到所有节点
                com.lee.entity.Service service = new com.lee.entity.Service();
                service.setFlowId(flowId);
                List<Node> nodes = flowDao.selectAllNode(service);
                Node next = null;
                Process process = flowDao.selectProcessById(processId);
                for (int i = 0; i < nodes.size(); i++) {
                    if (nodes.get(i).getId() == process.getNodeId()) {
                        if (i + 1 < nodes.size()) {
                            next = nodes.get(i + 1);
                            break;
                        }
                    }
                }
                System.out.println(next);
                //当前节点是最后节点
                if (next == null) {
                    //更新业务状态
                    flowDao.updateServiceStatus(serviceId, "审批通过");
                } else {
                    //不是最后节点则下一节点process
                    Process nextProcess = new Process();
                    nextProcess.setNodeId(next.getId());
                    nextProcess.setServiceId(serviceId);
                    nextProcess.setCreationtime(new Date());
                    flowDao.insertProcess(nextProcess);
                }
                break;
            case "0":
                //未通过当前节点
                //修改状态
                flowDao.updateServiceStatus(serviceId, "已拒绝");
                //更新进程
                flowDao.updateProcessStatus(processId, status);
                break;
            default:
                throw new ZxException(-1, "值错误");
        }
    }

    public List<Node> getAllNode(Integer flowId) {
        com.lee.entity.Service service = new com.lee.entity.Service();
        service.setFlowId(flowId);
        return flowDao.selectAllNode(service);
    }

    public Node getCurrentNode(Integer serviceId) {
        return flowDao.selectCurrentNode(serviceId);
    }
}
