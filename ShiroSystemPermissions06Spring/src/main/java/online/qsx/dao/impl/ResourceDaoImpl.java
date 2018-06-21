package online.qsx.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.qsx.dao.ResourceDao;
import online.qsx.model.ResourceModel;
import online.qsx.model.RoleModel;

@Repository
public class ResourceDaoImpl implements ResourceDao {

	@Autowired
	private QueryRunner queryRunner;

	@Override
	public List<ResourceModel> findByRoleModel(RoleModel roleModel) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer(" select tre.* from tb_role tr ");
		sql.append(" inner join tb_role_resource trr on trr.t_roleId=tr.roleId ");
		sql.append(" inner join tb_resource tre on tre.resourceId=trr.t_resourceId ");
		sql.append(" where tr.roleId= ?");

		List<Object> params = new ArrayList<Object>() {
			{
				add(roleModel.getRoleId());
			}
		};

		try {
			return queryRunner.query(sql.toString(), new BeanListHandler<>(ResourceModel.class), params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
