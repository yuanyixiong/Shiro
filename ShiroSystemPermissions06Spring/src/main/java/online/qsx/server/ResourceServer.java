package online.qsx.server;

import java.util.List;

import online.qsx.model.ResourceModel;
import online.qsx.model.RoleModel;

public interface ResourceServer {

	List<ResourceModel> findByRoleModel(RoleModel roleModel);

}
