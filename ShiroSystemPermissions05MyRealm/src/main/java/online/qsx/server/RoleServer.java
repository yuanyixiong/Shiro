package online.qsx.server;

import java.util.List;

import online.qsx.model.RoleModel;
import online.qsx.model.UserModel;

public interface RoleServer {

	List<RoleModel> findByUserModel(UserModel userModel);

}
