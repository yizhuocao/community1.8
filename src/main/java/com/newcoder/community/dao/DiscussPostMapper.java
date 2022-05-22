package com.newcoder.community.dao;

import com.newcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shkstart
 * @creat 2022--05--21 9:37
 */
@Mapper
//写注解才会被容器扫描接口，自动实现装配
public interface DiscussPostMapper {
    //这里写查询方法，配置文件写相关的sql，分页查询，查到的市多条数据，返回的是集合

    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId,@Param("offset") int offset,@Param("limit") int limit);
    //动态sql，有时候要拼userId，比如个人主页的帖子，有时候不用
    //支持分页 offset起始行号，limit每一页多少数据

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.
    int selectDiscussPostRows(@Param("userId") int userId);
}
