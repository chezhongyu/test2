package com.foreknow.service.impl;

import com.foreknow.bean.Staff;
import com.foreknow.dao.impl.StaffDaoImpl;
import com.foreknow.db.DBManager;
import com.foreknow.service.StaffService;
import com.foreknow.util.Pagination;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * create by foreknow on 2021/1/7
 */
public class StaffServiceImpl implements StaffService {
    @Override
    public boolean isValidate(Staff staff) throws SQLException {
        //连接数据库
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        //调用Dao中的方法
        StaffDaoImpl staffDao = new StaffDaoImpl();
        //将DBManger中获得到的conn传递给jdbcTemplate中的conn
        staffDao.setConnection(conn);

        boolean boo = false;
        try{
            boo = staffDao.insert(staff);
            conn.commit();
        } catch (Exception e) {
            try{
                conn.rollback();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return boo;

    }

    @Override
    public List<Object> queryInfo() {
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        //调用Dao中的方法
        StaffDaoImpl staffDao = new StaffDaoImpl();
        //将DBManger中获得到的conn传递给jdbcTemplate中的conn
        staffDao.setConnection(conn);
        List<Object> list=null;
        try {
            list = staffDao.queryAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteInfo(int id) throws SQLException {
        //连接数据库
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        //调用Dao中的方法
       StaffDaoImpl staffDao = new StaffDaoImpl();
        //将DBManger中获得到的conn传递给jdbcTemplate中的conn
       staffDao.setConnection(conn);
        boolean boo = false;
        try{
            boo = staffDao.delete(id);
            conn.commit();
        } catch (Exception e) {
            try{
                conn.rollback();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return boo;
    }

    @Override
    public boolean updateInfo(Staff staff) throws SQLException {
        return false;
    }

    @Override
    public Pagination getByPage(int pageSize, int pageNumber) throws SQLException {
        //连接数据库
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        //调用Dao中的方法
        StaffDaoImpl staffDao = new StaffDaoImpl();
        //将DBManger中获得到的conn传递给jdbcTemplate中的conn
        staffDao.setConnection(conn);
        Pagination pagination = null;
        try{
            pagination = staffDao.getStaffByPage(pageSize,pageNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagination;
    }
}
