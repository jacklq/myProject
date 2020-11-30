package com.lqtest.druid_mybatis.lqtest.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisParamConfig {
    private String database;

    private Boolean ssl;
    private String timeout;
    private String host;
    private String port;
    private String password;
    private Map<String,Object> lettuce;





}