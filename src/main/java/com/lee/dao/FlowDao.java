package com.lee.dao;

import com.lee.entity.Process;
import com.lee.entity.Service;

public interface FlowDao {

    int insertService(Service service);

    int insertProcess(Process process);
}
