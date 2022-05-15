package sas.view.impl;

import sas.dao.AdminDao;
import sas.dao.impl.AdminDaoImpl;
import sas.po.Admin;
import sas.view.AdminView;

import java.util.Scanner;

public class AdminViewImpl implements AdminView {


    private Scanner input = new Scanner(System.in);

    @Override
    public Admin login() {
        System.out.println("请输入您的管理员名称");
        String aname = input.next();
        System.out.println("请输入您的管理员密码");
        String password = input.next();

        AdminDao dao = new AdminDaoImpl();
        Admin admin = dao.getAdminByNameByPass(aname,password);

        return admin;
    }

}
