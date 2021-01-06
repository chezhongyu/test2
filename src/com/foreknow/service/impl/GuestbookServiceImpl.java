package com.foreknow.service.impl;

import com.foreknow.bean.Guestbook;
import com.foreknow.dao.impl.GuestbookDaoImpl;
import com.foreknow.db.DBManager;
import com.foreknow.service.GuestbookService;
import com.foreknow.util.Pagination;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GuestbookServiceImpl implements GuestbookService {
    @Override
    public boolean isValidate(Guestbook guestbook) throws SQLException {
        //连接数据库
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        //调用Dao中的方法
        GuestbookDaoImpl guestbookDao = new GuestbookDaoImpl();
        //将DBManger中获得到的conn传递给jdbcTemplate中的conn
        guestbookDao.setConnection(conn);

        boolean boo = false;
        try{
            boo = guestbookDao.insert(guestbook);
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
        GuestbookDaoImpl guestbookDao = new GuestbookDaoImpl();
        //将DBManger中获得到的conn传递给jdbcTemplate中的conn
        guestbookDao.setConnection(conn);
        List<Object> list=null;
        try {
            list = guestbookDao.queryAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteInfo(int id) {
        //连接数据库
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        //调用Dao中的方法
        GuestbookDaoImpl guestbookDao = new GuestbookDaoImpl();
        //将DBManger中获得到的conn传递给jdbcTemplate中的conn
        guestbookDao.setConnection(conn);
        //Guestbook guestbook = new Guestbook();
        boolean boo = false;
        try{
            boo = guestbookDao.delete(id);
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
    public boolean updateInfo(Guestbook guestbook) throws SQLException {
        //连接数据库
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        //调用Dao中的方法
        GuestbookDaoImpl guestbookDao = new GuestbookDaoImpl();
        //将DBManger中获得到的conn传递给jdbcTemplate中的conn
        guestbookDao.setConnection(conn);
        boolean boo = false;
        try{
            boo = guestbookDao.modify(guestbook);
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
    public Pagination getByPage(int pageSize,int pageNumber){
    //连接数据库
    DBManager dbManager = DBManager.getInstance();
    Connection conn = dbManager.getConnection();
    //调用Dao中的方法
    GuestbookDaoImpl guestbookDao = new GuestbookDaoImpl();
    //将DBManger中获得到的conn传递给jdbcTemplate中的conn
    guestbookDao.setConnection(conn);
    Pagination pagination = null;
    try{
        pagination = guestbookDao.getGuestbookByPage(pageSize,pageNumber);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return pagination;
}
}
