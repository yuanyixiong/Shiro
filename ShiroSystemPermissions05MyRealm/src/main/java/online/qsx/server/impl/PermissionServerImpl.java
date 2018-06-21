package online.qsx.server.impl;

import java.util.List;

import online.qsx.dao.PermissionDao;
import online.qsx.dao.impl.PermissionDaoImpl;
import online.qsx.model.PermissionModel;
import online.qsx.model.RoleModel;
import online.qsx.server.PermissionServer;

public class PermissionServerImpl implements PermissionServer {

	private PermissionDao permissionDao = new PermissionDaoImpl();

	@Override
	public List<PermissionModel> findByRoleModel(RoleModel roleModel) {
		return permissionDao.findByRoleModel(roleModel);
	}

}
