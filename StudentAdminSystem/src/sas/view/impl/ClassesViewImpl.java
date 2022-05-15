package sas.view.impl;

import sas.dao.ClassesDao;
import sas.dao.StudentDao;
import sas.dao.impl.ClassesDaoImpl;
import sas.dao.impl.StudentDaoImpl;
import sas.po.Classes;
import sas.po.Student;
import sas.view.ClassesView;

import java.util.List;
import java.util.Scanner;

public class ClassesViewImpl implements ClassesView {

    private Scanner input = new Scanner(System.in);

    @Override               //调用dao层得到学生信息
    public void listClassesAll() {


        ClassesDao dao = new ClassesDaoImpl();
        List<Classes> list = dao.listClasses();
        System.out.println("课程编号\t课程名称");
        for (Classes c : list){
            System.out.println("\t"+c.getCnum()+"\t"+c.getCname()+"\t\t");
        }

    }

    @Override
    public void editClasses() {
        String inputStr = "";                 //询问用户，以决定哪些需要更新，哪些不需要更新
        //不需要更新的就保持原来的值

        ClassesDao dao = new ClassesDaoImpl();
        Classes classes = new Classes();

        System.out.println("请输入需要修改信息课程对应的课程编码：");
        classes.setCnum(input.nextInt());

        System.out.println("是否需要修改课程名称（y/n）：");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入新的课程名称：");
            classes.setCname(input.next());
            //将更新的数据传回
            int result = dao.updateClassesName(classes);         //设置一个result值以判断是否更新成功
            if (result == 1){
                System.out.println("\n课程名称修改成功！\n");
            }
            else {
                System.out.println("\n课程名称修改失败！\n");
            }
        }

    }



}
