package com.test.web.utill;

import java.sql.*;

/**
 * Created by 石昊 on 2017/4/8.
 */
public interface DbConnect {
    //连接数据库
    public Connection getConnection();
    //关闭数据库
    public void closeConnection(Connection conn);
    //关闭预处理结果
    public void closePrepareedStatement(PreparedStatement pstmt);
    //关闭结果集
    public void closeResultSet(ResultSet rs);
}
