package com.test.web.test;

import com.test.web.dao.impliments.LoginDaoImpl;
import com.test.web.entity.User;

/**
 * Created by 石昊 on 2017/4/8.
 */
public class LoginTest {
    public static void main(String[] args){
        User user = new User();
        LoginDaoImpl userdao = new LoginDaoImpl();
        //user.setId(11);
        //user.setUsername("asdfghjkl");
        //user.setPassword("123456");
        //System.out.println("插入用户测试结果： "+userdao.InsertUser(user));
        //System.out.println("更新用户测试结果： "+userdao.UpdateUser(user));
        //System.out.println("列出所有用户测试结果： "+userdao.ListAll());
        //System.out.println("根据姓名查找用户测试结果： "+userdao.GetUserByUsername("admin"));
        System.out.println("删除用户测试结果： "+userdao.DeleteUser("asdfghjkl"));
    }
}
