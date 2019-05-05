package com.lee.dao;

import com.lee.entity.Node;
import com.lee.entity.Process;
import com.lee.entity.Service;
import com.lee.entity.ServiceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlowDao {

    int insertService(Service service);


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

    List<ServiceVo> selectServiceMonitor(@Param("offset") Integer offset,
                                         @Param("pageSize") Integer pageSize,
                                         @Param("title") String title,
                                         @Param("urgent") String urgent,
                                         @Param("flowTitle") String flowTitle,
                                         @Param("status") String status);

    Integer selectCountServiceMonitor(@Param("title") String title,
                                      @Param("urgent") String urgent,
                                      @Param("flowTitle") String flowTitle,
                                      @Param("status") String status);


    List<Node> selectAllNode(Service service);


    Integer insertProcess(Process process);

    List<Service> selectApplyToMe(Integer userId);


    Integer updateServiceStatus(@Param("id") Integer id, @Param("status") String status);

    Integer updateProcessStatus(@Param("id") Integer id, @Param("status") String status);

    Process selectProcessById(Integer processId);

    Node selectCurrentNode(Integer serviceId);
}
