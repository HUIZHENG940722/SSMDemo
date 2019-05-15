package com.example.ethan.mapper;

import com.example.ethan.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author HUIZHENG
 * @date 2019/5/14
 * @time 11:43
 * Created by IntelliJ IDEA.
 */
@MapperScan
public interface UserMapper {
    /**
     * 根据用户名和密码查找用户
     * @param userName
     * @param userPwd
     * @return
     */
    User queryUserByUserNameAndUserPwd(@Param("userName") String userName,@Param("userPwd") String userPwd);

    /**
     * 插入用户
     * @param user
     * @return
     */
    int insertUser(@Param("user") User user);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    User queryUserByUserName(@Param("userName") String userName);
}
