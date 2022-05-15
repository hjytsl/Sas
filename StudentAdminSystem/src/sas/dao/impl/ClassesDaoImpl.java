package sas.dao.impl;

import sas.dao.ClassesDao;
import sas.po.Classes;
import sas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassesDaoImpl implements ClassesDao {


    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override      //全查询课程信息
    public List<Classes> listClasses() {
        List<Classes> list = new ArrayList<>();   //长度属性，长度为0说明没有查询出来数据，不为0说明已经查询出数据

        String sql = "select * from class";   //sql语句
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                Classes classes = new Classes();
                classes.setCnum(rs.getInt("cnum"));
                classes.setCname(rs.getString("cname"));
                list.add(classes);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {           //这里需要使用finally来释放资源
            DBUtil.close(rs,pst,con);
        }
        return list;
    }

    @Override   //更改课程名
    public int updateClassesName(Classes classes) {
        int result = 0;
        String sql = "update class set cname = ? where cnum = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1 , classes.getCname());    //分别传入需亚更改的值
            pst.setInt(2 , classes.getCnum());
            result = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {           //这里需要使用finally来释放资源
            DBUtil.close(null,pst,con);  //由于没有用到ResultSet,我们在释放资源的时候就不用释放rs，直接传回null即可
        }
        return result;
    }
}
