package sas.dao;

import sas.po.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> listStudent();     //全查询学生信息

    public int updateStudentName(Student student);    //更改学生名字
    public int updateStudentMajor(Student student);    //更改学生名字
    public int updateStudentGender(Student student);    //更改学生名字
    public int updateStudentAge(Student student);    //更改学生名字

}
