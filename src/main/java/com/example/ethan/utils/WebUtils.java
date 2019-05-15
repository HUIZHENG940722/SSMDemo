package com.example.ethan.utils;

import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.UUID;

/**
 * 把表单数据封装到RegisterForm中
 * @author HUIZHENG
 * @date 2019/5/8
 * @time 20:23
 * Created by IntelliJ IDEA.
 */
public class WebUtils {
    /**
     * 将请求的表单数据转换成T对象
     * @param request 请求对象
     * @param clazz Class对象
     * @param <T> 泛型类
     * @return 返回一个bean对象
     */
    public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
        try{
            T bean = clazz.newInstance();
            Enumeration<String> e = request.getParameterNames();
            while(e.hasMoreElements()){
                String name = (String) e.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(bean, name, value);
            }
            return bean;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * 生成UUID主键
     * @return 返回bean主键
     */
    public static String makeId(){
        return UUID.randomUUID().toString();
    }
}
