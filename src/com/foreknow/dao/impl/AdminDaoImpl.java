package com.foreknow.dao.impl;

import com.foreknow.bean.Admin;
import com.foreknow.dao.AdminDao;
import com.foreknow.mapping.EntityMapping;
import com.foreknow.mapping.MappingFactory;

import java.util.List;

public class AdminDaoImpl extends BaseDAO implements AdminDao {

    @Override
    public Admin login (String username,String password){
//
//        DBManager dbManager = DBManager.getInstance();
//        //连接数据库
//        Connection conn=dbManager.getConnection();
//        //获取JdbcTemplate模板类对象
//        JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
//        //注入数据库的连接（如果没有注入  会发生空指针异常）
//        jdbcTemplate.setConnection(conn);
//        //要从工厂类MapL容器中获取到AdminMapping对象
//        MappingFactory mappingFactory = MappingFactory.getMappingFactory();
        EntityMapping mapping = mappingFactory.getMap(MappingFactory.ADMIN_MAPPING);
        //调用query方法
        List<Object> list = jdbcTemplate.query("select * from admin where username=? and password=?",mapping,username,password);

        if(list.size()>0){
            Admin admin = (Admin) list.get(0);
               return admin;
        }else{
            return null;
        }
        }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean insert(Admin admin) {
        return false;
    }

    @Override
    public boolean update(Admin admin) {
        return false;
    }

    @Override
    public Admin select(Integer id) {
        return null;
    }




}
