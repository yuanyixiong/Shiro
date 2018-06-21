package online.qsx.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class BaseDao {
	private String username="root";
	private String password="root";
	private String url="jdbc:mysql://localhost:3306/test";
	private String driverClassName="com.mysql.jdbc.Driver";

	private BasicDataSource ds;
	private QueryRunner queryRunner;

	public BaseDao() {
		ds = new BasicDataSource();
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setUrl(url);
		ds.setDriverClassName(driverClassName);
		queryRunner = new QueryRunner(ds);
	}

	public QueryRunner getQueryRunner() {
		return queryRunner;
	}

	public Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
