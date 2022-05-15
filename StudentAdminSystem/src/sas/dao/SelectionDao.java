package sas.dao;

import sas.po.Classes;
import sas.po.Selection;

import java.util.List;

public interface SelectionDao {

    public List<Selection> listSelection();         //全查询选课信息

    public int updateSelectionGrades(Selection selection);    //更改选课成绩

}
