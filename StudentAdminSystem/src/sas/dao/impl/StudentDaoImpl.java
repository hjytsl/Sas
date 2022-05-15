package sas.dao.impl;

import sas.dao.StudentDao;
import sas.po.Student;
import sas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override      //全查询学生信息
    public List<Student> listStudent() {
        List<Student> list = new ArrayList<>();   //长度属性，长度为0说明没有查询出来数据，不为0说明已经查询出数据

        String sql = "select * from student";   //sql语句
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setSnum(rs.getInt("snum"));
                student.setSname(rs.getString("sname"));
                student.setMajor(rs.getString("major"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                list.add(student);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {           //这里需要使用finally来释放资源
            DBUtil.close(rs,pst,con);
        }
        return list;
    }



    @Override              //更改学生姓名
    public int updateStudentName(Student student) {
        int result = 0;
        String sql = "update student set sname = ? where snum = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1 , student.getSname());    //分别传入需亚更改的值
            pst.setInt(2 , student.getSnum());
            result = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {           //这里需要使用finally来释放资源
            DBUtil.close(null,pst,con);  //由于没有用到ResultSet,我们在释放资源的时候就不用释放rs，直接传回null即可
        }
        return result;
    }

    @Override              //更改专业
    public int updateStudentMajor(Student student) {
        int result = 0;
        String sql = "update student set major = ? where snum = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1 , student.getMajor());    //分别传入需亚更改的值
            pst.setInt(2 , student.getSnum());
            result = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {           //这里需要使用finally来释放资源
            DBUtil.close(null,pst,con);  //由于没有用到ResultSet,我们在释放资源的时候就不用释放rs，直接传回null即可
        }
        return result;
    }

    @Override              //更改学生性别
    public int updateStudentGender(Student student) {
        int result = 0;
        String sql = "update student set gender = ? where snum = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1 , student.getGender());    //分别传入需亚更改的值
            pst.setInt(2 , student.getSnum());
            result = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {           //这里需要使用finally来释放资源
            DBUtil.close(null,pst,con);  //由于没有用到ResultSet,我们在释放资源的时候就不用释放rs，直接传回null即可
        }
        return result;
    }

    @Override              //更改学生年龄
    public int updateStudentAge(Student student) {
        int result = 0;
        String sql = "update student set age = ? where snum = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1 , student.getAge());    //分别传入需亚更改的值
            pst.setInt(2 , student.getSnum());
            result = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {           //这里需要使用finally来释放资源
            DBUtil.close(null,pst,con);  //由于没有用到ResultSet,我们在释放资源的时候就不用释放rs，直接传回null即可
        }
        return result;
    }

}
