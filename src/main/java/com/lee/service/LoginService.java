package com.lee.service;

import com.lee.common.ZxException;
import com.lee.dao.UserDao;
import com.lee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserDao userDao;

    public void login(User user) throws ZxException {
        if (userDao.updateUserTicket(user) == 0) {
            throw new ZxException("用户名或密码错误");
        }
    }

}
