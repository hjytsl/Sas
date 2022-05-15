package sas.view.impl;

import sas.dao.StudentDao;
import sas.dao.impl.StudentDaoImpl;
import sas.po.Student;
import sas.view.StudentView;

import java.util.List;
import java.util.Scanner;

public class StudentViewImpl implements StudentView {

    private Scanner input = new Scanner(System.in);


    @Override    //调用dao层得到学生信息
    public void listStudentAll() {


        StudentDao dao = new StudentDaoImpl();
        List<Student> list = dao.listStudent();
        System.out.println("学生编号\t学生姓名\t专业\t\t\t性别\t\t年龄");
        for (Student s : list){
            System.out.println(s.getSnum()+"\t"+s.getSname()+"\t\t"+s.getMajor()+"\t\t"+s.getGender()+"\t\t"+s.getAge());
        }
    }

    @Override
    public void editStudent() {


        String inputStr = "";                 //询问用户，以决定哪些需要更新，哪些不需要更新
        //不需要更新的就保持原来的值

        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();

        System.out.println("请输入需要修改信息学生对应的学生编码：");
        student.setSnum(input.nextInt());




        System.out.println("是否需要修改学生姓名（y/n）：");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入新的学生姓名：");
            student.setSname(input.next());
            //将更新的数据传回
            int result = dao.updateStudentName(student);         //设置一个result值以判断是否更新成功
            if (result == 1){
                System.out.println("\n学生姓名修改成功！\n");
            }
            else {
                System.out.println("\n学生姓名修改失败！\n");
            }
        }

        System.out.println("是否需要修改专业（y/n）：");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入新的专业：");
            student.setMajor(input.next());
            //将更新的数据传回
            int result = dao.updateStudentMajor(student);         //设置一个result值以判断是否更新成功
            if (result == 1){
                System.out.println("\n专业修改成功！\n");
            }
            else {
                System.out.println("\n专业修改失败！\n");
            }
        }

        System.out.println("是否需要修改性别（y/n）：");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入新的性别：");
            student.setGender(input.next());
            //将更新的数据传回
            int result = dao.updateStudentGender(student);         //设置一个result值以判断是否更新成功
            if (result == 1){
                System.out.println("\n性别修改成功！\n");
            }
            else {
                System.out.println("\n性别信息修改失败！\n");
            }
        }

        System.out.println("是否需要修改年龄（y/n）：");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入新的年龄：");
            student.setAge(input.nextInt());
            //将更新的数据传回
            int result = dao.updateStudentAge(student);         //设置一个result值以判断是否更新成功
            if (result == 1){
                System.out.println("\n年龄修改成功！\n");
            }
            else {
                System.out.println("\n年龄修改失败！\n");
            }
        }



    }

}
