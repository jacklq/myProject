package com.lqtest.druid_mybatis.lqtest.dao;

import com.lqtest.druid_mybatis.lqtest.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    UserEntity getById(Integer id);

    UserEntity getByFirstName(String firstName);

    void insert(UserEntity userEntity);
}
