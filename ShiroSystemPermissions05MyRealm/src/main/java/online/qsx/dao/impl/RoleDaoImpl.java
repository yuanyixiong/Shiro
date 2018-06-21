package online.qsx.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import online.qsx.dao.RoleDao;
import online.qsx.model.RoleModel;
import online.qsx.model.UserModel;

public class RoleDaoImpl extends BaseDao implements RoleDao {

	@Override
	public List<RoleModel> findByUserModel(UserModel userModel) {
		StringBuffer sql =new StringBuffer("select * from t_role where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(userModel!=null){
			if(userModel.getRole_id()>0){
				sql.append(" and id = ? ");
				params.add(userModel.getRole_id());
			}
		}
		try {
			return getQueryRunner().query(sql.toString(), new BeanListHandler<>(RoleModel.class), params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
