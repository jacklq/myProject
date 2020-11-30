package com.lqtest.druid_mybatis.lqtest.service;

import com.lqtest.druid_mybatis.lqtest.entity.Student;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @description
 * @create 2017-02-23 上午12:00
 * @email gxz04220427@163.com
 */

public interface  IAsyncTaskService {

    public void executeAsyncTask() throws InterruptedException;
    public void executeAsyncInsert();
}
