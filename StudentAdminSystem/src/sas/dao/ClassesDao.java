package sas.dao;

import sas.po.Classes;
import sas.po.Student;

import java.util.List;

public interface ClassesDao {

    public List<Classes> listClasses();     //全查询课程信息

    public int updateClassesName(Classes classes);    //更改课程名称

}
