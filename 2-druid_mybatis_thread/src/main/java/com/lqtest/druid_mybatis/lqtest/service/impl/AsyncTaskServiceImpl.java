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
public class AsyncTaskServiceImpl implements IAsyncTaskService {
    private static final Logger LOG = LoggerFactory.getLogger(AsyncTaskServiceImpl.class);
    @Value("${threadPool.corePoolSize}")
    public int threadSum;
    public static final int allNum = 40;
  
    @Autowired
    private IAsyncConcreMetService asyncConcreMetService;

    /*异步执行插入数据*/
    public void executeAsyncInsert() {
        List<Student> studentList = null;
        studentList = getPsrList();
        //入库开始时间
        Long inserOrUpdateBegin = System.currentTimeMillis();
        //接收集合各段的 执行的返回结果
        List<Future<String>> futureList = new ArrayList<>();
        //集合总条数
        if (studentList != null) {
            int listSize = studentList.size();

            int listStart, listEnd;
            //当总条数不足threadSum条时 用总条数 当做线程切分值
            if (threadSum > listSize) {
                threadSum = listSize;
            }

            //将list 切分多份 多线程执行
            for (int i = 0; i < threadSum; i++) {
                //计算切割  开始和结束
                listStart = listSize / threadSum * i;
                listEnd = listSize / threadSum * (i + 1);
                //最后一段线程会 出现与其他线程不等的情况
                if (i == threadSum - 1) {
                    listEnd = listSize;
                }
                //数据切断
                List<Student> sunList = studentList.subList(listStart, listEnd);

                //每段数据集合并行入库
                futureList.add(asyncConcreMetService.syncInsert(sunList, i));

            }

            //对各个线程段结果进行解析
            for (Future<String> future : futureList) {
                String str;
                if (null != future) {
                    try {
                        str = future.get();
                        LOG.info("current thread id =" + Thread.currentThread().getName() + ",result=" + str);
                    } catch (InterruptedException | ExecutionException e) {
                        LOG.info("线程运行异常！");
                    }
                } else {
                    LOG.info("线程运行异常！");
                }
            }
        }


        Long inserOrUpdateEnd = System.currentTimeMillis();
        LOG.info("此次更新数据花费时间为：" + (inserOrUpdateEnd - inserOrUpdateBegin));
    }
    /*造数据*/
    public List<Student> getPsrList() {
        List<Student> psrList = new ArrayList<>();
        for (int i = 0; i < allNum; i++) {
            Student student = new Student();
            student.setNum("2021111"+ i);
            student.setSex("1");
            student.setSname("magic");
            psrList.add(student);
        }
        return psrList;

    }


    public void executeAsyncTask() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            asyncConcreMetService.asyncConcreMet(i);
        }

    }


}