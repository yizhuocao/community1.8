package com.newcoder.community.service;

import com.newcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author shkstart
 * @creat 2022--05--16 15:29
 */
@Service //这个bean有容器管理
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    //构造器方法
    public AlphaService()
    {
        System.out.println("实例化AlphaService");
    }
    @PostConstruct  //构造器之后调用初始化方法
    public void init()
    {
        System.out.println("初始化AlphaService");
    }

    //销毁方法
    @PreDestroy
    public void destory()
    {
        System.out.println("销毁AlphaService");
    }
    public String find()
    {
        return alphaDao.select();
    }
}
