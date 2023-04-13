package com.dorm.dao;

import com.dorm.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Mapper
//将接口交给spring管理，方法中用参数@Param()来传递参数，从而可以与SQL字段名对应
@Repository

//user表方法
public interface UserDao {
//    把查询到的数据库信息返回控制层
    @Select("select id,username,password from user where username=#{username} and password=#{password}")
    User selectUser(@Param("username") String username, @Param("password") String password);
}
