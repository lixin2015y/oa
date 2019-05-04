package com.lee.dao;

import com.lee.entity.Process;
import com.lee.entity.Service;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FlowDao {

    int insertService(Service service);

    int insertProcess(Process process);

    List<Service> selectService(@Param("userId") Integer userId,
                                @Param("offset") Integer offset,
                                @Param("pageSize") Integer pageSize,
                                @Param("title") String title,
                                @Param("urgent") String urgent,
                                @Param("flowTitle") String flowTitle,
                                @Param("status") String status);


    Integer selectCountService(@Param("userId") Integer userId,
                               @Param("title") String title,
                               @Param("urgent") String urgent,
                               @Param("flowTitle") String flowTitle,
                               @Param("status") String status);

    Integer insetProcess();
}
