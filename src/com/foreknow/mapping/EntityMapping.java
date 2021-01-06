package com.foreknow.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityMapping {
    /**
     *将结果集中的一行数据映射为一个对象
     * @param  rs 结果集
     * @return  Object对象
     */
    public Object mapping(ResultSet rs) throws SQLException;
}
