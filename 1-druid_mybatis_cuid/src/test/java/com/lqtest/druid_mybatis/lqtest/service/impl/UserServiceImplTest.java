package com.lqtest.druid_mybatis.lqtest.service.impl;

import com.lqtest.druid_mybatis.lqtest.dao.UserDao;
import com.lqtest.druid_mybatis.lqtest.entity.UserEntity;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private static Logger LOGGER = Logger.getLogger(String.valueOf(UserServiceImpl.class));

    private  UserServiceImpl userService;
    @BeforeEach
    void setUp() {
        System.out.println("=====before each=====");
        this.userService =new UserServiceImpl();

        UserDao userDao = Mockito.mock(UserDao.class);
        this.userService.setUserDao(userDao);
    }

    @AfterEach
    void tearDown() {
        System.out.println("=====after each=====");
    }

    @Test
    void getById() {
        UserEntity userEntity=new UserEntity();
        userEntity.setId(111);
        userEntity.setMagicId("sss");
        userEntity.setFirstName("hah");
        userEntity.setLastName("liu");

        Mockito.when(this.userService.getUserDao().getById(Mockito.any(Integer.class))).thenReturn(userEntity);
        Assert.assertEquals(userEntity,this.userService.getById(111));

    }


}