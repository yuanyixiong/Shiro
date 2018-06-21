package online.qsx.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.qsx.dao.ResourceDao;
import online.qsx.model.ResourceModel;
import online.qsx.model.RoleModel;
import online.qsx.server.ResourceServer;

@Service
public class ResourceServerImpl implements ResourceServer {

	@Autowired
	private ResourceDao resourceDao;

	@Override
	public List<ResourceModel> findByRoleModel(RoleModel roleModel) {
		// TODO Auto-generated method stub
		return resourceDao.findByRoleModel(roleModel);
	}

}
