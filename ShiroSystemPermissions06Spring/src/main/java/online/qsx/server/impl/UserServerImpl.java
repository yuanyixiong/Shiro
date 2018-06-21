package online.qsx.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.qsx.dao.UserDao;
import online.qsx.model.UserModel;
import online.qsx.server.UserServer;

@Service
public class UserServerImpl implements UserServer {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}

}
