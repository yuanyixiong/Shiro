package online.qsx.server.impl;

import online.qsx.dao.UserDao;
import online.qsx.dao.impl.UserDaoImpl;
import online.qsx.model.UserModel;
import online.qsx.server.UserServer;

public class UserServerImpl implements UserServer {
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserModel(new UserModel(username));
	}

}
