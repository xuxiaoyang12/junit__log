package com.mxiaixy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 获取数据库连接
 * Created by Mxia on 2016/12/9.
 */
public class ConnectionManager {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_22";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection(){
        Connection connection = null;
        //加载数据库驱动
        try {
            Class.forName(DRIVER);
            //获取数据库连接
            connection = DriverManager.getConnection(URL,NAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
