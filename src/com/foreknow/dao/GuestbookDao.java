package com.foreknow.dao;

import com.foreknow.bean.Guestbook;
import com.foreknow.util.Pagination;

import java.sql.SQLException;
import java.util.List;

public interface GuestbookDao {
    /**
     * 添加留言信息
     * @param guestbook
     * @return
     */
    public boolean insert(Guestbook guestbook) throws SQLException;

    /**
     * 查询所有留言信息
     *
     */
    public List<Object> queryAll() throws SQLException;

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(int id)throws SQLException;

    /**
     * 修改
     * @param guestbook
     * @return
     * @throws SQLException
     */
    public boolean modify(Guestbook guestbook)throws SQLException;

    /**
     * 分页查询留言信息
     *
     * @param pageSize 每页显示的记录数
     * @param pageNumber 当前页码
     * @return
     * @throws SQLException
     */

    public Pagination getGuestbookByPage(int pageSize,int pageNumber) throws SQLException;


}
