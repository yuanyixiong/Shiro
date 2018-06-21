package online.qsx.server.impl;

import java.util.List;

import online.qsx.dao.RoleDao;
import online.qsx.dao.impl.RoleDaoImpl;
import online.qsx.model.RoleModel;
import online.qsx.model.UserModel;
import online.qsx.server.RoleServer;

public class RoleServerImpl implements RoleServer {

	private RoleDao roleDao=new RoleDaoImpl();
	
	@Override
	public List<RoleModel> findByUserModel(UserModel userModel) {
		return roleDao.findByUserModel(userModel);
	}

}
