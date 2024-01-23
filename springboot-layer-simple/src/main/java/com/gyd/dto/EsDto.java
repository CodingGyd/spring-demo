package com.gyd.dto;

import java.util.Date;

/**
 * @ClassName EsDto
 * @Description es实体描述
 * @Author guoyading
 * @Date 2023/12/21 14:07
 * @Version 1.0
 */
public class EsDto {
    private Long id;
    private String title;
    private String phone;
    private Date createTime;
    private Date modifyTime;
    private String address;
    private Integer age;

    public EsDto() {
    }

    public EsDto(Long id, String title, String phone, Date createTime, Date modifyTime, String address, Integer age) {
        this.id = id;
        this.title = title;
        this.phone = phone;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.address = address;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
