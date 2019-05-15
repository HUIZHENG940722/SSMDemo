package com.example.ethan.service;

import com.example.ethan.pojo.User;

/**
 * @author HUIZHENG
 * @date 2019/5/14
 * @time 12:11
 * Created by IntelliJ IDEA.
 */
public interface UserService {
    /**
     * 根据用户名和密码登录系统业务
     * @param userName
     * @param userPwd
     * @return
     */
    User login(String userName,String userPwd);

    /**
     * 插入用户
     * @param user
     * @return
     */
    boolean insert(User user);

    /**
     * 查找用户名是否存在
     * @param userName
     * @return
     */
    User checkUserName(String userName);
}

