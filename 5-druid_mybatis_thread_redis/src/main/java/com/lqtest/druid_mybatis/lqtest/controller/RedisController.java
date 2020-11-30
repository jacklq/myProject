package com.lqtest.druid_mybatis.lqtest.controller;

import com.lqtest.druid_mybatis.lqtest.entity.Student;
import com.lqtest.druid_mybatis.lqtest.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @program: springbootdemo
 * @Date: 2019/1/25 15:03
 * @Author: Mr.Zheng
 * @Description:
 */
@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {

    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/set")
    public String redisStringSet(@RequestParam String key, @RequestParam String value) {
        redisUtil.set(key, value);
        return "存储成功";
    }

    /**
     * 取值
     *
     * @param key 键
     * @return 值
     */
    @RequestMapping("/get")
    public Object redisStringGet(@RequestParam String key) {
        return redisUtil.get(key);
    }

    /**
     * 批量存值
     */
    @RequestMapping("/batch/set")
    public void redisBatchSet() {
        Map<String, Object> map = new HashMap<>(3);
        map.put("test1", "value1");
        map.put("test2", "value2");
        map.put("test3", "value3");
        redisUtil.batchSet(map);
    }

    /**
     * 批量取值
     *
     * @return 值列表
     */
    @RequestMapping("/batch/get")
    public List<Object> redisBatchGet() {
        // 批量取值，如果某个 key 不存在，则值为 null
        List<String> list = new ArrayList<>(3);
        list.add("test1");
        list.add("test2");
        list.add("test3");
        return redisUtil.batchGet(list);
    }
}