package com.gyd.springdemo.ioc;

import org.springframework.beans.factory.DisposableBean;

/**
 * @ClassName StudentInfo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/14 11:01
 * @Version 1.0
 */
public class StudentInfo implements DisposableBean {
    /**学生编号*/
    private String stuNo;
    /**学生姓名*/
    private String stuName;
    /**所属班级*/
    private ClassesInfo classesInfo;
    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public ClassesInfo getClassesInfo() {
        return classesInfo;
    }

    public void setClassesInfo(ClassesInfo classesInfo) {
        this.classesInfo = classesInfo;
    }

    @Override
    public void destroy() throws Exception {
//        System.out.println("hehehhe destroy");
    }
}
