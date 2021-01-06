package com.foreknow.test;

import com.foreknow.db.DBManager;
import com.foreknow.db.JdbcTemplate;
import com.foreknow.mapping.EntityMapping;
import com.foreknow.mapping.MappingFactory;

import java.sql.Connection;
import java.util.List;

public class TestDBManager {
    public static void main(String[] args) {
        DBManager dbManager = DBManager.getInstance();
        //连接数据库
        Connection conn=dbManager.getConnection();
        //获取JdbcTemplate模板类对象
        JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        //注入数据库的连接（如果没有注入  会发生空指针异常）
        jdbcTemplate.setConnection(conn);
        //要从工厂类Map容器中获取到AdminMapping对象
        MappingFactory mappingFactory = MappingFactory.getMappingFactory();
        EntityMapping mapping = mappingFactory.getMap(MappingFactory.ADMIN_MAPPING);
        //调用query方法
        List<Object> list = jdbcTemplate.query("select * from admin where username=? and password=?",mapping,"123","123");
        System.out.println(list.size());


    //添加数据
//        int isRight =jdbcTemplate.update("insert into admin(username,password,age,school,phone) values(?,?,?,?,?)","tom","121",12,"www","21");
//        System.out.println(isRight);
    }
}
