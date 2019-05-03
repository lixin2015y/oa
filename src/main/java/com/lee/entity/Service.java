package com.lee.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Service implements Serializable {

    private static final long serialVersionUID = 8942985730580509002L;

    private Integer id;

    private String title;

    private String urgent;

    private String appendix;

    @JSONField(name = "creationtime", format = "yyyy-MM-dd HH点mm分")
    private Date creationtime;

    private Integer userId;

    private Integer flowId;

    private String status;

    private Flow flow;


    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", urgent='" + urgent + '\'' +
                ", appendix='" + appendix + '\'' +
                ", creationtime=" + creationtime +
                ", userId=" + userId +
                ", flowId=" + flowId +
                ", status='" + status + '\'' +
                '}';
    }
}
