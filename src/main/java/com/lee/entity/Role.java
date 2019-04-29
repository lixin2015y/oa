package com.lee.entity;

import java.io.Serializable;

public class Role implements Serializable {

    private static final long serialVersionUID = -4791823061079283780L;

    private Integer id;

    private String auth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", auth='" + auth + '\'' +
                '}';
    }
}
