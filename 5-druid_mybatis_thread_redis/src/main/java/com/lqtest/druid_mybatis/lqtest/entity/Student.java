package com.lqtest.druid_mybatis.lqtest.entity;

import java.util.Date;

public class Student {
    private Long id;

    private String num;

    private String sname;

    private String sex;

    private String age;

    private Date cretim;

    public Student(Long id, String num, String sname, String sex, String age, Date cretim) {
        this.id = id;
        this.num = num;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.cretim = cretim;
    }

    public Student() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public Date getCretim() {
        return cretim;
    }

    public void setCretim(Date cretim) {
        this.cretim = cretim;
    }
}