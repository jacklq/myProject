package com.lqtest.druid_mybatis.lqtest.controller;

import com.lqtest.druid_mybatis.lqtest.service.IAsyncTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 异步操作注意点
 *  1-在起始类上添加@EnableAsync
 *  2-async方法不可以和其调用者在同一类中
 *  3-定义自己的线程池如本项目中的ThreadConfig,若想用默认的线程池则不用配置ThreadConfig，异步方法上不用指定线程池名称
 *
 * */

/*浏览器输入：http://localhost:8081/sptest/asynWork
 * */
@RestController
public class AsynTaskController {
    private Logger LOG= LoggerFactory.getLogger(CuidController.class);
    @Autowired
    private IAsyncTaskService asyncTaskService;

    /*异步执行*/
    @RequestMapping(value = "/asynWork", method = RequestMethod.POST)
    public void asynWork() throws InterruptedException {
        LOG.info("asynWork執行");
        Long begin = System.currentTimeMillis();
        asyncTaskService.executeAsyncTask();
        Long end = System.currentTimeMillis();
        LOG.info("耗费时间："+(begin-end));
    }

    /*异步插入数据表*/
    @RequestMapping(value = "/asynInsert", method = RequestMethod.POST)
    public void executeAsyncInsert() {
        LOG.info("asynInsert執行");
        asyncTaskService.executeAsyncInsert();

    }
}