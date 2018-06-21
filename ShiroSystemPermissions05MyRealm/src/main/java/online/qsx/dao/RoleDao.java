package online.qsx.dao;

import java.util.List;

import online.qsx.model.RoleModel;
import online.qsx.model.UserModel;

public interface RoleDao {
	
	List<RoleModel> findByUserModel(UserModel userModel);
}
