package com.lqtest.druid_mybatis.lqtest.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lqtest.druid_mybatis.lqtest.entity.RedisParamConfig;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * redis配置类

 */
@Configuration
@EnableCaching //开启注解
public class RedisConfig extends CachingConfigurerSupport {


    @Autowired
    private RedisParamConfig redisParamConfig;



   /**
   * 连接池配置
   * */
    @Bean
    LettuceConnectionFactory lettuceConnectionFactory() {
        // 连接池配置
        Map<String,Object> lettuce=new HashMap<>();
        lettuce=redisParamConfig.getLettuce();
        Map<String,Object> pool=(Map<String, Object>) lettuce.get("pool");
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        Integer maxIdle=(Integer) pool.get("max-idle");
        Integer minIdle=(Integer) pool.get("min-idle");
        Integer maxTotal=(Integer) pool.get("max-active");
        Integer maxWaitMillis=(Integer) pool.get("max-wait");
        Integer database=Integer.valueOf(redisParamConfig.getDatabase());
        String host=redisParamConfig.getHost();
        String port=redisParamConfig.getPort();
        String password=redisParamConfig.getPassword();

        poolConfig.setMaxIdle(maxIdle == null ? 8 : maxIdle);
        poolConfig.setMinIdle(minIdle == null ? 1 : minIdle);
        poolConfig.setMaxTotal(maxTotal == null ? 8 : maxTotal);
        poolConfig.setMaxWaitMillis(maxWaitMillis == null ? 5000L : maxWaitMillis);
        LettucePoolingClientConfiguration lettucePoolingClientConfiguration = LettucePoolingClientConfiguration.builder()
                .poolConfig(poolConfig)
                .build();
        /* case1:单机redis*/
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setDatabase(database);
        redisConfig.setHostName(host==null||"".equals(host)?"localhost":host);
        redisConfig.setPort(Integer.valueOf(port==null||"".equals(port)?"6379":port));
        if (password != null && !"".equals(password)) {
            redisConfig.setPassword(RedisPassword.of(password));
        }

         /*  case2: 哨兵redis*/
        /* RedisSentinelConfiguration redisConfig = new RedisSentinelConfiguration();
        */
      /*  集群redis*/
        /*RedisClusterConfiguration redisConfig = new RedisClusterConfiguration();
        Set<RedisNode> nodeses = new HashSet<>();
        String[] hostses = nodes.split("-");
        for (String h : hostses) {
            h = h.replaceAll("\\s", "").replaceAll("\n", "");
            if (!"".equals(h)) {
                String host = h.split(":")[0];
                int port = Integer.valueOf(h.split(":")[1]);
                nodeses.add(new RedisNode(host, port));
            }
        }
        redisConfig.setClusterNodes(nodeses);
        // 跨集群执行命令时要遵循的最大重定向数量
        redisConfig.setMaxRedirects(3);
        redisConfig.setPassword(password);*/

        return new LettuceConnectionFactory(redisConfig, lettucePoolingClientConfiguration);
    }

    /**
     * retemplate相关配置
     * @param lettuceConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        lettuceConnectionFactory.setShareNativeConnection(false);/*设置为false否则不能有多个连接*/
        // 配置连接工厂
        template.setConnectionFactory(lettuceConnectionFactory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSeial.setObjectMapper(om);

        // 值采用json序列化
        template.setValueSerializer(jacksonSeial);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());

        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSeial);
        template.afterPropertiesSet();

        return template;
    }



}