2020-11-20
     开始springcloud项目，增加注册中心和网关

2020-11-23  https://www.jianshu.com/p/cce702d44b7d
    增加Hystrix服务保护，
        注意在pom中引入Hystrix服务保护时，注意其版本
         <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
                    <version>2.0.2.RELEASE</version>
         </dependency>

2020-11-26   https://www.jianshu.com/p/f6c0793e8458
    增加分布式配置中心SpringCloudConfig