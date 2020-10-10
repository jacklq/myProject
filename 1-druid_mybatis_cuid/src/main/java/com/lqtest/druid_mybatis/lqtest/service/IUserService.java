package com.lqtest.druid_mybatis.lqtest.service;

import com.lqtest.druid_mybatis.lqtest.entity.UserEntity;


public interface IUserService {
    public UserEntity getById(Integer id);

    public UserEntity getByFirstName(String name);
    public void insert(UserEntity userEntity);
}

