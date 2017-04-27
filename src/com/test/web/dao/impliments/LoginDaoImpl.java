package com.test.web.dao.impliments;


import com.test.web.entity.User;
import com.test.web.utill.DbConnect;
import com.test.web.utill.impliments.DbConnectImpl;
import com.test.web.dao.LoginDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 石昊 on 2017/4/8.
 */
public class LoginDaoImpl implements LoginDao {
    //增加用户
    private static String insertUser = "INSERT INTO user (username,password) VALUES (?,?)";
    //删除用户
    private static String deleteUser = "DELETE FROM user WHERE username = ?";
    //更新用户信息
    private static String updateUser = "UPDATE user SET username = ?,password = ? WHERE id = ?";
    //列出所有用户
    private static String listUser = "SELECT * FROM user";
    //按用户名查找
    private static String getUserByUsername = "SELECT id,username,password FROM user WHERE username = ?";

    private Connection conn;
    private DbConnect dbConn;

    public LoginDaoImpl(){
        this.dbConn = new DbConnectImpl();
    }

    /*
     *增加用户
     */
    public boolean InsertUser(User user){
        boolean flag = false;
        conn = null;
        PreparedStatement pstmt = null;
        try{
            this.conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(insertUser);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            if(pstmt.executeUpdate()>0){
                flag=true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dbConn.closePrepareedStatement(pstmt);
            dbConn.closeConnection(conn);
        }
        return flag;
    }
    /*
     *删除用户
     */
    public boolean DeleteUser(String username) {
        boolean flag = false;
        conn = null;
        PreparedStatement pstmt = null;
        try{
            this.conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(deleteUser);
            pstmt.setString(1,username);
            if(pstmt.executeUpdate()>0){
                flag = true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dbConn.closePrepareedStatement(pstmt);
            dbConn.closeConnection(conn);
        }
        return flag;
    }
    /*
     *更新用户信息
     */
    public boolean UpdateUser(User user){
        boolean flag = false;
        conn = null;
        PreparedStatement pstmt = null;
        try{
            this.conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(updateUser);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setInt(3,user.getId());
            System.out.println(pstmt.executeUpdate());
            if(pstmt.executeUpdate()>0){
                flag = true;
            }
        }catch (Exception ex){
            ex.printStackTrace();;
        }finally {
            dbConn.closePrepareedStatement(pstmt);
            dbConn.closeConnection(conn);
        }
        return flag;
    }
    /*
     *列出所有用户
     */
    public List<User> ListAll() {
        User user = null;
        List<User> list = new ArrayList<>();
        conn = null;
        PreparedStatement pstmt = null;
        try{
            this.conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(listUser);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
            dbConn.closeResultSet(rs);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dbConn.closePrepareedStatement(pstmt);
            dbConn.closeConnection(conn);
        }
        return list;
    }
    /*
     *根据用户名查找用户
     */
    public User GetUserByUsername(String username) {
        User user = null;
        conn = null;
        PreparedStatement pstmt = null;
        try{
            this.conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(getUserByUsername);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            dbConn.closeResultSet(rs);
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            dbConn.closePrepareedStatement(pstmt);
            dbConn.closeConnection(conn);
        }
        return user;
    }
}
