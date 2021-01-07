package com.foreknow.dao.impl;

import com.foreknow.bean.Staff;
import com.foreknow.dao.StaffDao;
import com.foreknow.mapping.EntityMapping;
import com.foreknow.mapping.MappingFactory;
import com.foreknow.util.OraclePagination;
import com.foreknow.util.Pagination;

import java.sql.SQLException;
import java.util.List;

/**
 * create by foreknow on 2021/1/7
 */
public class StaffDaoImpl extends BaseDAO implements StaffDao {
    @Override
    public List<Object> queryAll() throws SQLException {
        String sql="select * from staff";
        EntityMapping mapping = mappingFactory.getMap(MappingFactory.STAFF_MAPPING);
        List<Object> list = jdbcTemplate.query(sql,mapping);
        return list;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "delete from staff where id=?";
        int boo =  jdbcTemplate.update(sql,id);
        return boo==1;
    }

    @Override
    public boolean modify(Staff staff) throws SQLException {
        return false;
    }

    @Override
    public boolean insert(Staff staff) throws SQLException {
        int boo = jdbcTemplate.update("insert into staff(number,name,sex,age,height,date,nation,place,phone,email,political,department,post,entrydate,workingdate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",staff.getNumber(),staff.getName(),staff.getSex(),staff.getAge(),staff.getHeight(),staff.getDate(),staff.getNation(),staff.getPlace(),staff.getPhone(),staff.getEmail(),staff.getPolitical(),staff.getDepartment(),staff.getPost(),staff.getEntrydate(),staff.getWorkingdate());
        if(boo==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Pagination getStaffByPage(int pageSize, int pageNumber) throws SQLException {
        String sql = "select * from  staff ";
        Pagination pagination = new OraclePagination(sql,pageSize,pageNumber);
        return pagination;
    }
}
