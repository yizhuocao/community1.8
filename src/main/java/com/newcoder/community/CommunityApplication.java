package com.newcoder.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan({"com.newcoder.community.dao"})
public class CommunityApplication {

	public static void main(String[] args) {
		//方法底层自动创建spring容器，自动扫描某些包下的某些类，自动装配
		//bean中有controller注解才会扫描
		SpringApplication.run(CommunityApplication.class, args);
	}

}
