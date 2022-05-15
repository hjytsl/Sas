package sas.view.impl;

import sas.dao.ClassesDao;
import sas.dao.SelectionDao;
import sas.dao.impl.ClassesDaoImpl;
import sas.dao.impl.SelectionDaoImpl;
import sas.po.Classes;
import sas.po.Selection;
import sas.view.SelectionView;

import java.util.List;
import java.util.Scanner;

public class SelectionViewImpl implements SelectionView {

    private Scanner input = new Scanner(System.in);

    @Override             //调用dao层得到选课信息
    public void listSelectionAll() {

        SelectionDao dao = new SelectionDaoImpl();
        List<Selection> list = dao.listSelection();
        System.out.println("课程编号\t学生编号\t\t成绩");
        for (Selection se : list){
            System.out.println("\t"+se.getCnum()+"\t"+se.getSnum()+"\t\t"+se.getGrades());
        }

    }

    @Override
    public void editSelection() {
        String inputStr = "";                 //询问用户，以决定哪些需要更新，哪些不需要更新
        //不需要更新的就保持原来的值

        SelectionDao dao = new SelectionDaoImpl();
        Selection selection = new Selection();

        System.out.println("请输入需要修改成绩对应的课程编码：");
        selection.setCnum(input.nextInt());
        System.out.println("请输入需要修改成绩对应的学生编码：");
        selection.setSnum(input.nextInt());

        System.out.println("是否需要修改成绩（y/n）：");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入新的成绩：");
            selection.setGrades(input.nextDouble());
            //将更新的数据传回
            int result = dao.updateSelectionGrades(selection);         //设置一个result值以判断是否更新成功
            if (result == 1){
                System.out.println("\n成绩修改成功！\n");
            }
            else {
                System.out.println("\n成绩修改失败！\n");
            }
        }
    }

}
