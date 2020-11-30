package com.lqtest.druid_mybatis.lqtest.service.impl;

import com.lqtest.druid_mybatis.lqtest.dao.StudentDao;
import com.lqtest.druid_mybatis.lqtest.entity.Student;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.logging.Logger;

class StudentServiceImplTest {
    private static Logger LOGGER = Logger.getLogger(String.valueOf(StudentServiceImpl.class));

    private StudentServiceImpl userService;
    @BeforeEach
    void setUp() {
        System.out.println("=====before each=====");
        this.userService =new StudentServiceImpl();

        StudentDao StudentDao = Mockito.mock(StudentDao.class);
        this.userService.setStudentDao(StudentDao);
    }

    @AfterEach
    void tearDown() {
        System.out.println("=====after each=====");
    }

    @Test
    void getById() {
        Student student=new Student();
        student.setId(111L);
        student.setSex("sss");
        student.setNum("hah");
        student.setSname("liu");

        Mockito.when(this.userService.getStudentDao().selectByPrimaryKey(Mockito.any(Long.class))).thenReturn(student);
        Assert.assertEquals(student,this.userService.selectByPrimaryKey(1L));

    }


}