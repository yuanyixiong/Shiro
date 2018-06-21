package online.qsx.server;

import java.util.List;

import online.qsx.model.PermissionModel;
import online.qsx.model.RoleModel;

public interface PermissionServer {

	List<PermissionModel> findByRoleModel(RoleModel roleModel);

}
