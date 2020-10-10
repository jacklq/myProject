//package com.lqtest.druid_mybatis.lqtest;
//
//import com.lqtest.druid_mybatis.lqtest.entity.UserEntity;
//import com.lqtest.druid_mybatis.lqtest.service.IUserService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.sql.DataSource;
//
//@SpringBootTest
//class LqtestApplicationTests {
//
//	@Autowired
//	DataSource dataSource;
//	@Autowired
//	IUserService iUserService;
//	@Test
//	void contextLoads() {
//		UserEntity userEntity=new UserEntity();
//		iUserService.insert(userEntity);
//		System.out.println(dataSource.getClass());
//	}
//
//}
