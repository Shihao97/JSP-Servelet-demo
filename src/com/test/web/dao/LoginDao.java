package com.test.web.dao;

import com.test.web.entity.User;
import java.util.List;

/**
 * Created by 石昊 on 2017/4/8.
 */
public interface LoginDao {
    //增加用户
    public boolean InsertUser(User user);
    //删除用户
    public boolean DeleteUser(String username);
    //更新用户信息
    public boolean UpdateUser(User user);
    //列出所有用户
    public List<User> ListAll();
    //根据用户名查找用户
    public User GetUserByUsername(String username);
}
