package online.qsx.dao;

import online.qsx.model.UserModel;

public interface UserDao {

	UserModel findByUserName(String username);

}
