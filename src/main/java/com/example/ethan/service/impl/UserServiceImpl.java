package com.example.ethan.service.impl;

import com.example.ethan.mapper.UserMapper;
import com.example.ethan.pojo.User;
import com.example.ethan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUIZHENG
 * @date 2019/5/14
 * @time 12:11
 * Created by IntelliJ IDEA.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String userName, String userPwd) {
        User user = userMapper.queryUserByUserNameAndUserPwd(userName, userPwd);
        return user;
    }

    @Override
    public boolean insert(User user) {
        int num = userMapper.insertUser(user);
        System.out.println(num);
        if (num>0){
            return true;
        }
        return false;
    }

    @Override
    public User checkUserName(String userName) {
        User user=userMapper.queryUserByUserName(userName);
        return user;
    }
}
