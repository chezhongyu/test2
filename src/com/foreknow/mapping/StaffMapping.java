package com.foreknow.mapping;

import com.foreknow.bean.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * create by foreknow on 2021/1/7
 */
public class StaffMapping  implements EntityMapping{
    @Override
    public Object mapping(ResultSet rs) throws SQLException {
        Staff staff = new Staff();
        staff.setId(rs.getInt("id"));
        staff.setNumber(rs.getString("number"));
        staff.setName(rs.getString("name"));
        staff.setSex(rs.getString("sex"));
        staff.setAge(rs.getInt("age"));
        staff.setHeight(rs.getString("height"));
        staff.setDate(rs.getString("date"));
        staff.setNation(rs.getString("nation"));
        staff.setPlace(rs.getString("place"));
        staff.setPhone(rs.getString("phone"));
        staff.setEmail(rs.getString("email"));
        staff.setPolitical(rs.getString("political"));
        staff.setDepartment(rs.getString("department"));
        staff.setPost(rs.getString("post"));
        staff.setEntrydate(rs.getString("entrydate"));
        staff.setWorkingdate(rs.getString("workingdate"));
        return staff;
    }
}
