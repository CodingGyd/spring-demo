package com.gyd.springdemo.ioc;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author lvqi
 */ //班级信息

public class ClassesInfo implements InitializingBean {
    /**班级名称*/
    private String classesNo;
    /**班级姓名*/
    private String classesName;

    public String getClassesNo() {
        return classesNo;
    }

    public void setClassesNo(String classesNo) {
        this.classesNo = classesNo;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        System.out.println("启动时加载了我");
    }

    @PostConstruct
    public void init() {
//        System.out.println("我是PostConstruct");
    }
}
