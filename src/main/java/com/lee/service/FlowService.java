package com.lee.service;

import com.lee.dao.FlowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowService {

    @Autowired
    FlowDao flowDao;

    public void apply(com.lee.entity.Service service) {
        flowDao.insertService(service);
    }
}
