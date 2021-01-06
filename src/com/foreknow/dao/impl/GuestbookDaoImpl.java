package com.foreknow.dao.impl;

import com.foreknow.bean.Guestbook;
import com.foreknow.dao.GuestbookDao;
import com.foreknow.mapping.EntityMapping;
import com.foreknow.mapping.MappingFactory;
import com.foreknow.util.OraclePagination;
import com.foreknow.util.Pagination;

import java.sql.SQLException;
import java.util.List;

public class GuestbookDaoImpl extends BaseDAO implements GuestbookDao {

    @Override
    public boolean insert(Guestbook guestbook) throws SQLException {

        int boo = jdbcTemplate.update("insert into guestbook(name,phone,email,title,content,time) values(?,?,?,?,?,?)",guestbook.getName(),guestbook.getPhone(),guestbook.getEmail(),guestbook.getTitle(),guestbook.getContent(),guestbook.getTime());
    if(boo==1){
        return true;
    }else{
        return false;
    }
    }

    @Override
    public List<Object> queryAll() throws SQLException {
        String sql="select * from guestbook";
        EntityMapping mapping = mappingFactory.getMap(MappingFactory.GUEST_MAPPING);
        List<Object> list = jdbcTemplate.query(sql,mapping);
        return list;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from guestbook where id=?";
        int boo =  jdbcTemplate.update(sql,id);
        return boo==1;

    }

    @Override
    public boolean modify(Guestbook guestbook) throws SQLException {
        String sql = "update guestbook set name=?,phone=?,email=?,title=?,content=?,time=?";
        int boo = jdbcTemplate.update(sql,guestbook.getName(),guestbook.getPhone(),guestbook.getEmail(),guestbook.getTitle(),guestbook.getContent(),guestbook.getTime());
        return boo==1;
    }

    @Override
    public Pagination getGuestbookByPage(int pageSize, int pageNumber) throws SQLException {
        String sql = "select * from  guestbook ";
        Pagination pagination = new OraclePagination(sql,pageSize,pageNumber);
        return pagination;
    }


}
