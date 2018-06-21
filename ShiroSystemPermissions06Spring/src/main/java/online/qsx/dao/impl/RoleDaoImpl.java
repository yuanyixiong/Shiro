package online.qsx.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.qsx.dao.RoleDao;
import online.qsx.model.RoleModel;
import online.qsx.model.UserModel;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private QueryRunner queryRunner;

	@Override
	public List<RoleModel> findByUserModel(UserModel userModel) {
		StringBuffer sql = new StringBuffer(" select tr.* from tb_role tr ");
		sql.append(" inner join tb_user_role  tur on tur.t_roleId=tr.roleId ");
		sql.append(" inner join tb_user tu on tu.userId=tur.t_userId ");
		sql.append(" where  tu.userId=?");

		List<Object> params = new ArrayList<Object>() {
			{
				add(userModel.getUserId());
			}
		};

		try {
			return queryRunner.query(sql.toString(), new BeanListHandler<>(RoleModel.class), params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
