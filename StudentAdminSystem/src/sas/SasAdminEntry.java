package sas;

import sas.po.Admin;
import sas.view.AdminView;
import sas.view.ClassesView;
import sas.view.SelectionView;
import sas.view.StudentView;
import sas.view.impl.AdminViewImpl;
import sas.view.impl.ClassesViewImpl;
import sas.view.impl.SelectionViewImpl;
import sas.view.impl.StudentViewImpl;

import java.util.Scanner;

public class SasAdminEntry {

    public void work(){     //打印出系统入口的界面

        Scanner input = new Scanner(System.in);
        System.out.println("#########################################################################");
        System.out.println("#\t\t\t\t\t\t\t欢迎使用学生管理系统\t\t\t\t\t\t\t#");
        System.out.println("#########################################################################");

        AdminView adminView = new AdminViewImpl();
        Admin admin = adminView.login();

        StudentView studentView = new StudentViewImpl();

        ClassesView classesView = new ClassesViewImpl();

        SelectionView selectionView = new SelectionViewImpl();


        //管理员登录
        if(admin != null){     //登录成功时

            int menu = 0;
            while(menu!=5){
                //输出主菜单
                System.out.println("\n===========1.查看学生==2.查看课程==3.查看选课==4.修改信息==5.退出系统============");
                System.out.println("请选择功能：");
                menu = input.nextInt();
                switch(menu){
                    case 1:           //查看学生    全查询
                        studentView.listStudentAll();
                        break;
                    case 2:            //查看课程   全查询
                        classesView.listClassesAll();
                        break;
                    case 3:            //查看选课    全查询
                        selectionView.listSelectionAll();
                        break;
                    case 4:             //修改信息     操作数据库
                        infoManager();      //进入二级菜单
                        break;
                    case 5:              //退出系统
                        System.out.println("-----------------------------感谢使用学生管理系统-----------------------------");
                        System.out.println("--------------------------------欢迎下次光临--------------------------------");
                        break;
                    default:          //输入错误选项时
                        System.out.println("没有您输入的选项！");
                        break;
                }
            }

        }
        else{        //密码错误时
            System.out.println("\n管理员名称或密码输入错误！\n");
        }

    }


    private void infoManager(){


        StudentView studentView = new StudentViewImpl();

        ClassesView classesView = new ClassesViewImpl();

        SelectionView selectionView = new SelectionViewImpl();


        Scanner input = new Scanner(System.in);


        int menu = 0 ;
        while (menu != 4){
            //输出二级菜单
            System.out.println("\n=============二级菜单（信息修改）1.修改学生信息==2.修改课程信息==3.修改选课信息==4.返回一级菜单==============");
            System.out.println("请选择功能：");
            menu = input.nextInt();
            switch (menu){
                case 1:      //修改学生信息
                    studentView.editStudent();
                    break;
                case 2:               //修改课程信息
                    classesView.editClasses();
                    break;
                case 3:             //修改选课信息
                    selectionView.editSelection();
                    break;
                case 4:                 //退出系统
                    break;
                default:          //输入错误选项时
                    System.out.println("没有您输入的选项！");
                    break;
            }
        }



    }



    public static void main(String[] args){
        //调用以上的方法，以打开管理员入口界面
        new SasAdminEntry().work();
    }


}
