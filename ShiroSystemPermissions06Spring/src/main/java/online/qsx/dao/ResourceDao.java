package online.qsx.dao;

import java.util.List;

import online.qsx.model.ResourceModel;
import online.qsx.model.RoleModel;

public interface ResourceDao {

	List<ResourceModel> findByRoleModel(RoleModel roleModel);

}
