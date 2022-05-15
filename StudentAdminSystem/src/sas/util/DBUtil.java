package sas.util;

import java.sql.*;


public class DBUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/sasdb?characterEncoding=utf-8";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    //获取connection
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(DRIVER);   //传入驱动
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD); //这里需要传入地址、用户名以及密码
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    //关闭  ResultSet   Connection   和   PreparedStatement
    public static void close(ResultSet rs,PreparedStatement pst,Connection con ){
        if (rs != null){     //这里需要判断，如果传入的值为空，则不关闭，否则会出现报错
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (pst != null){     //这里需要判断，如果传入的值为空，则不关闭，否则会出现报错
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pst = null;
        }
        if (con != null){     //这里需要判断，如果传入的值为空，则不关闭，否则会出现报错
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con = null;
        }

    }

}
