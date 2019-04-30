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
        service.setStatus("待审批");
        try {
            flowService.apply(service);
        } catch (Exception e) {
            return Result.error();
        }
        return Result.success();
    }

    @PostMapping("getMyLaunchFlow")
    ResponseMessage getMyLaunchFlow() {

        return Result.success();
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
