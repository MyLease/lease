package com.mcmc.common.entity;

/**
 * Created by sunlei on 2017/9/2.
 * 城市参数对照表
 */
public class ParamCity {
    private int id;
    private int provinceId;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
