package com.newcoder.community.dao;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author shkstart
 * @creat 2022--05--16 15:11
 */

@Repository
@Primary  //δΌεθ£ι
public class AlphaDaoMyBatisImpl implements AlphaDao {
    @Override
    public String select() {
        return "MyBatis";
    }
}
