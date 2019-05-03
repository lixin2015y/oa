package com.lee.service;

import com.lee.dao.FlowDao;
import com.lee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowService {

    @Autowired
    FlowDao flowDao;

    public void apply(com.lee.entity.Service service) {
        flowDao.insertService(service);
    }

    public List<com.lee.entity.Service> getService(User user, Integer pageNum, Integer pageSize, String title, String urgent, String flowTitle, String status) {
        return flowDao.selectService(user.getId(), pageSize * (pageNum - 1), pageSize, title, urgent, flowTitle, status);
    }

    public Integer getCountService(Integer userId, String title, String urgent, String flowTitle, String status) {
        return flowDao.selectCountService(userId, title, urgent, flowTitle, status);
    }
}
