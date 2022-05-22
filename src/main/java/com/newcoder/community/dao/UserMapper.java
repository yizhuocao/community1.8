package com.newcoder.community.dao;

import com.newcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author shkstart
 * @creat 2022--05--20 16:51
 */
@Mapper
//有一个类封装表里的数据
public interface UserMapper {
    //需要提供一个配置文件，为每一个方法提供所需要的sql，mybatis底层自动生成一个实现类
    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(@Param("id") int id,@Param("status") int status);

    int updateHeader(@Param("id")int id, @Param("headerUrl") String headerUrl);

    int updatePassword(@Param("id")int id, @Param("password") String password);
}
