package com.lee.contoller;

import com.lee.common.ResponseMessage;
import com.lee.common.Result;
import com.lee.common.ZxException;
import com.lee.entity.User;
import com.lee.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@RequestMapping("login")
@RestController
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    LoginService loginService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("login")
    ResponseMessage login(User user, HttpServletResponse response) {

        String ticket = UUID.randomUUID().toString().substring(0, 20);

        user.setTicket(ticket);

        try {
            loginService.login(user);
        } catch (ZxException e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }

        Cookie cookie = new Cookie("ticket", ticket);

        cookie.setPath("/");

        cookie.setMaxAge(1800);

        response.addCookie(cookie);

        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();

        valueOperations.set(ticket, user, 1800, TimeUnit.SECONDS);

        return Result.success();
    }

    @GetMapping("logout")
    void logout(@CookieValue(name = "ticket", required = false) String ticket, HttpServletResponse response) {
//        redisTemplate.delete(ticket);
        try {
            response.sendRedirect("/admin/index/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
