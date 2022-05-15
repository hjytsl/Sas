package sas.dao.impl;

import sas.dao.SelectionDao;
import sas.po.Classes;
import sas.po.Selection;
import sas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectionDaoImpl implements SelectionDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;


    @Override    //全查询选课信息
    public List<Selection> listSelection() {
        List<Selection> list = new ArrayList<>();   //长度属性，长度为0说明没有查询出来数据，不为0说明已经查询出数据

        String sql = "select * from selection";   //sql语句
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                Selection selection= new Selection();
                selection.setCnum(rs.getInt("cnum"));
                selection.setSnum(rs.getInt("snum"));
                selection.setGrades(rs.getDouble("grades"));
                list.add(selection);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {           //这里需要使用finally来释放资源
            DBUtil.close(rs,pst,con);
        }
        return list;
    }

    @Override
    public int updateSelectionGrades(Selection selection) {
        int result = 0;
        String sql = "update selection set grades = ? where cnum = ? and snum = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setDouble(1 , selection.getGrades());    //分别传入需亚更改的值
            pst.setInt(2 , selection.getCnum());
            pst.setInt(3 , selection.getSnum());
            result = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {           //这里需要使用finally来释放资源
            DBUtil.close(null,pst,con);  //由于没有用到ResultSet,我们在释放资源的时候就不用释放rs，直接传回null即可
        }
        return result;
    }

}
