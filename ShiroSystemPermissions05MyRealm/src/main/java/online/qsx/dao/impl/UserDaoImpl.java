package online.qsx.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;

import online.qsx.dao.UserDao;
import online.qsx.model.UserModel;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public UserModel findByUserModel(UserModel userModel) {
		StringBuffer sql =new StringBuffer(" select * from t_user where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(userModel!=null){
			if(userModel.getUserName()!=null&&userModel.getUserName().trim().length()>0){
				sql.append(" and username = ? ");
				params.add(userModel.getUserName().trim());
			}
		}
		try {
			return getQueryRunner().query(sql.toString(), new BeanHandler<UserModel>(UserModel.class), params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
