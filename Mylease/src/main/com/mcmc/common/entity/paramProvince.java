package main.com.mcmc.common.entity;

/**
 * Created by sunlei on 2017/9/2.
 * 省份参数对照表
 */
public class paramProvince {
    private int id;
    private String code;//省份代码
    private String name;
    private String createdTime;//创建时间
    private String lastModifiedTime;//最后修改时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}
