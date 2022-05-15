package com.lou.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

/**
 * @author lqw
 * @date 2022/3/10-7:48 下午
 */
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    @TableLogic
    private Integer deleted;

    @Version//代表这乐观锁的注解
    private Integer version;
    //字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date  createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date  updateTime;

    public User() {
    }

    public User(Long id, String name, Integer age, String email, Integer deleted, Integer version, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.deleted = deleted;
        this.version = version;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", deleted=" + deleted +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}