package com.lee.contoller;

import com.lee.common.ResponseMessage;
import com.lee.common.Result;
import com.lee.model.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("user")
public class UserController {

    @Autowired
    HostHolder hostHolder;

    @PostMapping("getUser")
    ResponseMessage getUser() {
        
        return Result.success(hostHolder.getUser());
    }

}
