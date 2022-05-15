package sas.dao.impl;

import sas.dao.AdminDao;
import sas.po.Admin;
import sas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {


    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override     //管理员登录
    public Admin getAdminByNameByPass(String aname, String password) {
        Admin admin = null;   //若查询失败，则返回一个空值，反之则返回查询到的值
        String sql = "select * from admin where aname=? and password=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,aname);
            pst.setString(2,password);
            rs = pst.executeQuery();
            while (rs.next()){
                admin = new Admin();
                admin.setAnum(rs.getInt("anum"));
                admin.setAname(rs.getString("aname"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {           //这里需要使用finally来释放资源
            DBUtil.close(rs,pst,con);
        }
        return admin;
    }

}
