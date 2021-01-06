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
        //�������ݿ�
        Connection conn=dbManager.getConnection();
        //��ȡJdbcTemplateģ�������
        JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        //ע�����ݿ�����ӣ����û��ע��  �ᷢ����ָ���쳣��
        jdbcTemplate.setConnection(conn);
        //Ҫ�ӹ�����Map�����л�ȡ��AdminMapping����
        MappingFactory mappingFactory = MappingFactory.getMappingFactory();
        EntityMapping mapping = mappingFactory.getMap(MappingFactory.ADMIN_MAPPING);
        //����query����
        List<Object> list = jdbcTemplate.query("select * from admin where username=? and password=?",mapping,"123","123");
        System.out.println(list.size());


    //�������
//        int isRight =jdbcTemplate.update("insert into admin(username,password,age,school,phone) values(?,?,?,?,?)","tom","121",12,"www","21");
//        System.out.println(isRight);
    }
}
