package com.newcoder.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author shkstart
 * @creat 2022--05--16 10:00
 */

@Repository ("alphaHibernate")  //访问容器，容器自动扫描这个bean，装配到容器里
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
