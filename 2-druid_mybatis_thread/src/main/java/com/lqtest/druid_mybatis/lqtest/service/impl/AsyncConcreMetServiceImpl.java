package com.lqtest.druid_mybatis.lqtest.service.impl;

import com.lqtest.druid_mybatis.lqtest.dao.StudentDao;
import com.lqtest.druid_mybatis.lqtest.entity.Student;
import com.lqtest.druid_mybatis.lqtest.service.IAsyncConcreMetService;
import com.lqtest.druid_mybatis.lqtest.service.IAsyncTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@Service
public class AsyncConcreMetServiceImpl implements IAsyncConcreMetService {
    private static final Logger LOG = LoggerFactory.getLogger(AsyncConcreMetServiceImpl.class);

    @Autowired
    private StudentDao studentDao;

    /**
     * 异步方法和其调用者不能在同一类中，否则不能异步
     */

    /*异步执行*/
    @Async("asyncExecutor")
    public void asyncConcreMet(int i) throws InterruptedException {
        LOG.info("线程" + Thread.currentThread().getName() + " 执行异步任务：" + i);
        Thread.sleep(5000);
    }


    /*异步执行插入数据,指定线程池*/
    @Async("asyncExecutor")
    public Future<String> syncInsert(List<Student> studentList, int pageIndex) {

        LOG.info("thread name " + Thread.currentThread().getName()+String.format("此批数据的段数为:%s 此段数据的数据条数为:%s", pageIndex, studentList.size()));
        //声明future对象
        Future<String> result = new AsyncResult<String>("success,  "+"thread name " + Thread.currentThread().getName()+String.format("    此批段数为:%s 此段条数为:%s", pageIndex, studentList.size()));
        //循环遍历该段旅客集合
        if (null != studentList && studentList.size() > 0) {
            for (Student user : studentList) {
                try {
                    //数据入库操作
                    studentDao.insert(user);
                } catch (Exception e) {

                    //记录出现异常的时间，线程name
                    result = new AsyncResult<String>("fail,time=" + System.currentTimeMillis() + ",thread id=" + Thread.currentThread().getName() + ",pageIndex=" + pageIndex);
                    continue;
                }
            }
        }
        return result;
    }
}