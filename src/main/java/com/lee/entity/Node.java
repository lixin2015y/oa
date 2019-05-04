package com.lee.entity;

import java.io.Serializable;
import java.util.Date;

public class Node implements Serializable {

    private static final long serialVersionUID = -4791823061079283780L;

    private Integer id;

    private String name;

    private Integer order;

    private Integer userId;

    private Integer flowId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", userId=" + userId +
                ", flowId='" + flowId + '\'' +
                '}';
    }
}
