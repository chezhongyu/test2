package com.foreknow.service.impl;

import com.foreknow.bean.Admin;
import com.foreknow.dao.impl.AdminDaoImpl;
import com.foreknow.db.DBManager;
import com.foreknow.service.AdminService;

import java.sql.Connection;

public class AdminServiceImpl implements AdminService {
    @Override
    public Admin isValidate(String username, String password) {
        //连接数据库
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        //调用Dao中的方法
        AdminDaoImpl adminDao = new AdminDaoImpl();
        //将DBManger中获得到的conn传递给jdbcTemplate中的conn
        adminDao.setConnection(conn);
        //调用Dao中的方法
        Admin admin = adminDao.login(username,password);
        return admin;
    }


}
