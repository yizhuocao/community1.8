package com.newcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author shkstart
 * @creat 2022--05--16 15:48
 */
@Configuration
public class AlphaConfig {
    @Bean
    public SimpleDateFormat simpleDateFormat()
    {
        //方法返回的对象将被装配到容器里
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
