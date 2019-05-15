package com.example.ethan.web.controller;

import com.example.ethan.pojo.RegisterForm;
import com.example.ethan.pojo.User;
import com.example.ethan.service.UserService;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;
import static org.apache.commons.beanutils.BeanUtils.copyProperties;

/**
 * @author HUIZHENG
 * @date 2019/5/14
 * @time 11:22
 * Created by IntelliJ IDEA.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录界面
     * @return
     */
    @RequestMapping(value = "/loginUi")
    public String loginUi(){
        return "login";
    }

    /**
     * 注册界面
     * @return
     */
    @RequestMapping(value = "/registerUi")
    public String registerUi(){
        return "register";
    }

    /**
     * 注册跳转
     * @param registerForm
     * @return
     */
    @RequestMapping(value = "/register")
    public ModelAndView register(RegisterForm registerForm){
        ModelAndView andView=new ModelAndView();

        //表单格式校验失败
        if (!registerForm.validate()){
            andView.setViewName("login");
            return andView;
        }
        User user=new User();
        //注册日期转换器
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        //设置用户id
        user.setId(UUID.randomUUID().toString());
        try {
            //把表单数据封装到user中
            copyProperties(user,registerForm);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //插入用户成功
        if (userService.insert(user)){
            andView.setViewName("registerSuccess");
        }else {//注册失败
            andView.setViewName("register");
        }
        return andView;
    }

    /**
     * 校验用户名是否存在
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkUser")
    public String checkUserName(@RequestParam("userName")String userName){
        System.out.println(userName);
        User user=userService.checkUserName(userName);
        System.out.println(userName);
        if (user==null){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 登录跳转
     * @param userName
     * @param userPwd
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam("userName") String userName, @RequestParam("userPwd") String userPwd){
        ModelAndView andView=new ModelAndView();
        User login = userService.login(userName, userPwd);
        if (login==null){
            andView.addObject("loginError","用户名或密码错误");
            andView.setViewName("login");
        }else {
            andView.addObject("user",login);
            andView.setViewName("main");
        }
        return andView;
    }
}
