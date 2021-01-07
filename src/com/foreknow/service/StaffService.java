package com.foreknow.service;

import com.foreknow.bean.Staff;
import com.foreknow.util.Pagination;

import java.sql.SQLException;
import java.util.List;

public interface StaffService {

    /**
     *添加方法
     * @param staff
     * @return
     */

    public boolean isValidate(Staff staff) throws SQLException;

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


    public boolean updateInfo(Staff staff)throws SQLException;

    /**
     * 分页查询
     * @param pageSize
     * @param pageNumber
     * @return
     * @throws SQLException
     */
    public Pagination getByPage(int pageSize, int pageNumber)throws SQLException;


}
