package com.test.web.utill.impliments;

import com.test.web.utill.DbConnect;
import java.sql.*;

/**
 * Created by 石昊 on 2017/4/8.
 */
public class DbConnectImpl implements DbConnect {
    private String db_driver = "com.mysql.jdbc.Driver";
    private String db_url = "jdbc:mysql://localhost:3306/db_login";
    private String db_username = "root";
    private String db_password = "admin";
    private Connection conn=null;

    public DbConnectImpl(){
        try{
            Class.forName(db_driver);
            this.conn = DriverManager.getConnection(db_url,db_username,db_password);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    /*
     *连接数据库
     */
    public Connection getConnection() {
        return this.conn;
    }

    /*
     *关闭数据库
     */
    public  void closeConnection(Connection conn){
        if(conn!=null){
            try{
                conn.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    /*
     *关闭预处理结果
     */
    public void closePrepareedStatement(PreparedStatement pstmt){
        if(pstmt!=null){
            try{
                pstmt.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    /*
     *关闭结果集
     */
    public void closeResultSet(ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
