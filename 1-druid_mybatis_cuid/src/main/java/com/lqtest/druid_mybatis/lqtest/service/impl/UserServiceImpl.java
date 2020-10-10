package com.lqtest.druid_mybatis.lqtest.service.impl;

import com.lqtest.druid_mybatis.lqtest.dao.UserDao;
import com.lqtest.druid_mybatis.lqtest.entity.UserEntity;
import com.lqtest.druid_mybatis.lqtest.service.IUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserDao userDao;

    public UserEntity getById(Integer id) {
        return userDao.getById(id);
    }

    public UserEntity getByFirstName(String name) {
        return userDao.getByFirstName(name);
    }


    public void insert(UserEntity userEntity){ userDao.insert(userEntity);
    };



    /** ** ********单元测试用************/
    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    /*************************************/
}
