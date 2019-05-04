package com.lee.entity;

import java.io.Serializable;
import java.util.Date;

public class Process implements Serializable {

    private static final long serialVersionUID = -4791823061079283780L;

    private Integer id;

    private String status;

    private Integer nodeId;

    private Integer userId;

    private Integer serviceId;

    private Date creationtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", nodeId=" + nodeId +
                ", userId=" + userId +
                ", serviceId=" + serviceId +
                ", creationtime=" + creationtime +
                '}';
    }
}
