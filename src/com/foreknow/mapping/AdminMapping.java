package com.foreknow.mapping;

import com.foreknow.bean.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapping implements EntityMapping {

    @Override
    public Object mapping(ResultSet rs) throws SQLException {
        Admin admin = new Admin();
        admin.setId(rs.getInt("id"));
        admin.setUsername(rs.getString("username"));
        admin.setPassword(rs.getString("password"));
        admin.setAge(rs.getInt("age"));
        admin.setSchool(rs.getString("school"));
        admin.setPhone(rs.getString("phone"));
        return admin;



    }
}
