package online.qsx.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.qsx.dao.UserDao;
import online.qsx.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private QueryRunner queryRunner;

	@Override
	public UserModel findByUserName(String username) {
		StringBuffer sql = new StringBuffer(" select * from tb_user where username = ?  ");
		List<Object> params = new ArrayList<Object>() {
			{
				add(username);
			}
		};
		try {
			return queryRunner.query(sql.toString(), new BeanHandler<UserModel>(UserModel.class), params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
