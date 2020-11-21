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


