package com.foreknow.mapping;

import com.foreknow.bean.Guestbook;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestbookMapping implements EntityMapping {
    @Override
    public Object mapping(ResultSet rs) throws SQLException {
        Guestbook guestbook = new Guestbook();
        guestbook.setId(rs.getInt("id"));
        guestbook.setName(rs.getString("name"));
        guestbook.setPhone(rs.getString("phone"));
        guestbook.setEmail(rs.getString("email"));
        guestbook.setTitle(rs.getString("title"));
        guestbook.setContent(rs.getString("content"));
        guestbook.setTime(rs.getString("time"));
        return guestbook;




    }
}
