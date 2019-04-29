package com.lee.service;

import com.lee.dao.UserDao;
import com.lee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUserByTicket(String ticket) {
        return userDao.selectUserByTicket(ticket);
    }
}
