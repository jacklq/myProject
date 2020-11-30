2020-10-9 更新
    可参考https://segmentfault.com/a/1190000016875496
    主要是DruidConfiguration类的配置和yml文件配置，其他无特殊之处
	通过springboot+mybatis+druid,实现增删改查，通过http://localhost:8089/sptest/druid 可查看sql执行过程，账号密码见文件DruidConfiguration
	和单元测试

2020-11-10
   此项目实现功能  springboot+mybatis+druid
        1-mybatis-generator插件链接数据库实现mybatis自动代码生成，可生成三部分内容，dao层，实体，和xml文件
            使用方式可以参考https://www.jianshu.com/p/b519e9ef605f
            注意将数据库连接时添加amp;运行时右侧找到maven找到该插件，双击即可运行
        2-使用druid连接池，具体配置信息见DruidConfiguration和yml文件中的datasource配置
        3-实现数据库的增删改查，批量增删改查

2020-11-21
    项目更新  引入多线程，异步插入数据 具体见AsynTaskController层
         异步操作注意点
         1-在起始类上添加@EnableAsync
         2-async方法不可以和其调用者在同一类中
         3-定义自己的线程池如本项目中的ThreadConfig,若想用默认的则不用配置ThreadConfig，异步方法上不用指定线程池名称

2020-11-29
    项目刚更新  实现redis操作，增删改查等、具体见RedisController层
        redis配置见文件RedisConfig,    从yml文件获取配置信息见RedisParamConfig

