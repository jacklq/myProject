package com.lqtest.druid_mybatis.lqtest.controller;

import com.lqtest.druid_mybatis.lqtest.entity.UserEntity;
import com.lqtest.druid_mybatis.lqtest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/*浏览器输入：http://localhost:8089/sptest/insert
 * */
@RestController
public class HelloController {

    @Autowired
    private IUserService userService;

    /*插入数据表*/
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void asynInsert() {
        System.out.println("Insert執行");
        UserEntity userEntity=new UserEntity();
        userEntity.setFirstName("asda");
        userEntity.setMagicId("asda");
        userEntity.setLastName("asda");
        userEntity.setId(1111122);

        userService.insert(userEntity);

    }
}