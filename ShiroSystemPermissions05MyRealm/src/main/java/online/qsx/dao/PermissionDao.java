package online.qsx.dao;

import java.util.List;

import online.qsx.model.PermissionModel;
import online.qsx.model.RoleModel;

public interface PermissionDao {

	List<PermissionModel> findByRoleModel(RoleModel roleModel);
}
