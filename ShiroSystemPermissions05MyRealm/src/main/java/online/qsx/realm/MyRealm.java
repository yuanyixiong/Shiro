package online.qsx.realm;

import java.util.HashSet;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import online.qsx.model.PermissionModel;
import online.qsx.model.RoleModel;
import online.qsx.model.UserModel;
import online.qsx.server.PermissionServer;
import online.qsx.server.RoleServer;
import online.qsx.server.UserServer;
import online.qsx.server.impl.PermissionServerImpl;
import online.qsx.server.impl.RoleServerImpl;
import online.qsx.server.impl.UserServerImpl;

public class MyRealm extends AuthorizingRealm {
	private UserServer userServer=new UserServerImpl();
	private RoleServer roleServer=new RoleServerImpl();
	private PermissionServer permissionServer=new PermissionServerImpl();
	
	// ����������Ϊ��ǰ��½�ɹ����û�����Ȩ�޺ͽ�ɫ���Ѿ���½�ɹ��ˣ�
	@SuppressWarnings("serial")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = (String) principals.getPrimaryPrincipal(); // ��ȡ�û���

		UserModel userModel=userServer.findByUserName(username);//��ѯ�û�
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		List<RoleModel> roleModels=roleServer.findByUserModel(userModel);//��ѯ��ɫ
		
		// ���ý�ɫ
		authorizationInfo.setRoles(new HashSet<String>() {
			{
				for (RoleModel roleModel : roleModels) {
					add(roleModel.getRoleName());//��ӽ�shiro��ɫ����
				}
			}
		});
		// ����Ȩ��
		authorizationInfo.setStringPermissions(new HashSet<String>() {
			{
				//���ݽ�ɫ���,��ѯȨ��
				for (RoleModel roleModel : roleModels) {
					List<PermissionModel> permissionModels=permissionServer.findByRoleModel(roleModel);
					for (PermissionModel permissionModel : permissionModels) {
						add(permissionModel.getPermissionName());//��ӽ�shiroȨ�޿���
					}
				}
			}
		});
		return authorizationInfo;
	}

	// ������������֤��ǰ��¼���û�����ȡ��֤��Ϣ
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal(); // ��ȡ�û���
		UserModel userModel=userServer.findByUserName(username);
		AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userModel.getUserName(), userModel.getPassword(), "myRealm");
		return authcInfo;
	}

}
