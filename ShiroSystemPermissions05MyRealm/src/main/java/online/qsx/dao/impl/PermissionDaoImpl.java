package online.qsx.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import online.qsx.dao.PermissionDao;
import online.qsx.model.PermissionModel;
import online.qsx.model.RoleModel;

public class PermissionDaoImpl extends BaseDao implements PermissionDao {

	@Override
	public List<PermissionModel> findByRoleModel(RoleModel roleModel) {
		StringBuffer sql = new StringBuffer("select * from t_permission where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (roleModel != null) {
			if (roleModel.getId() > 0) {
				sql.append(" and role_id = ? ");
				params.add(roleModel.getId());
			}
		}
		try {
			return getQueryRunner().query(sql.toString(), new BeanListHandler<>(PermissionModel.class),params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
