package com.lee.contoller;

import com.lee.common.ResponseMessage;
import com.lee.common.Result;
import com.lee.model.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("flow")
public class FlowController {

    @Autowired
    HostHolder hostHolder;

    @PostMapping("postFlow")
    ResponseMessage postFlow() {

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
