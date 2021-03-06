package com.foreknow.service;

import com.foreknow.bean.Guestbook;
import com.foreknow.util.Pagination;

import java.sql.SQLException;
import java.util.List;

public interface GuestbookService {
    /**
     *添加方法
     * @param guestbook
     * @return
     */

    public boolean isValidate(Guestbook guestbook) throws SQLException;

    /**
     * 查询方法
     * @return
     */
    public List<Object> queryInfo();

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteInfo(int id)throws SQLException;


    public boolean updateInfo(Guestbook guestbook)throws SQLException;

    /**
     * 分页查询
     * @param pageSize
     * @param pageNumber
     * @return
     * @throws SQLException
     */
    public Pagination getByPage(int pageSize, int pageNumber)throws SQLException;




}
