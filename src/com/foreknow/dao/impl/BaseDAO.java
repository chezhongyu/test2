package com.foreknow.dao.impl;






import com.foreknow.db.JdbcTemplate;
import com.foreknow.mapping.MappingFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;

public class BaseDAO {

	protected JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();// JDBC模板
	protected MappingFactory mappingFactory = MappingFactory.getMappingFactory();// mapping工厂实例
	protected Log logger = LogFactory.getLog("DAOLogger");

	/**
	 * 注入数据库连接类
	 * 
	 * @param connection
	 */
	public void setConnection(Connection connection) {
		jdbcTemplate.setConnection(connection);
	}
}
