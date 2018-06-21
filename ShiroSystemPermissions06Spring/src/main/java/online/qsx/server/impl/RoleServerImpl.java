package online.qsx.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.qsx.dao.RoleDao;
import online.qsx.model.RoleModel;
import online.qsx.model.UserModel;
import online.qsx.server.RoleServer;

@Service
public class RoleServerImpl implements RoleServer {

	@Autowired
	private RoleDao roleDao;

	@Override
	public List<RoleModel> findByUserModel(UserModel userModel) {
		// TODO Auto-generated method stub
		return roleDao.findByUserModel(userModel);
	}

}
