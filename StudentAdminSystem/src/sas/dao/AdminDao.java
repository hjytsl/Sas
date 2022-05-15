package sas.dao;

import sas.po.Admin;

public interface AdminDao {

    public Admin getAdminByNameByPass(String aname, String password);   //管理员登录

}
