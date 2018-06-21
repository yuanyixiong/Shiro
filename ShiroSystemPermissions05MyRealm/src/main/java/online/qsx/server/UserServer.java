package online.qsx.server;

import online.qsx.model.UserModel;

public interface UserServer {

	UserModel findByUserName(String username);
}
