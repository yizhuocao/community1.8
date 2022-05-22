package com.newcoder.community;

import com.newcoder.community.dao.AlphaDao;
import com.newcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=CommunityApplication.class)  //运行的代码就是以CommunityApplication为配置类
public class CommunityApplicationTests implements ApplicationContextAware{
	//哪个类想得到容器就实现接口
	//spring在扫描组件时，会检测到bean(ApplicationContextAware),调用了set方法，把自身传进来
	private ApplicationContext applicationContext;//记录容器
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	//测试spring容器
	@Test
	public void testApplicationContext()
	{
		System.out.println(applicationContext);
		//从容器里获取自动装配的bean
		AlphaDao alphaDao=applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());
		alphaDao=applicationContext.getBean("alphaHibernate",AlphaDao.class);
		System.out.println(alphaDao.select());
	}

	@Test
	public void testBeanManagement()
	{
		//通过容器获取service
		AlphaService alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Test
	public void testBeanConfig()
	{
		SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired
	@Qualifier("alphaHibernate")
	private AlphaDao alphaDao;  //希望spring容器把AlphaDao注入给属性

	@Autowired
	private AlphaService alphaService;

	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Test
	public void testDI()
	{
		System.out.println(alphaDao);
		System.out.println(alphaService);
		System.out.println(simpleDateFormat);
	}
}
