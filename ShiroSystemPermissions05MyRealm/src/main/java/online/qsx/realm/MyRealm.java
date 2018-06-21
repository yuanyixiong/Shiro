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
	
	// 方法：用来为当前登陆成功的用户授予权限和角色（已经登陆成功了）
	@SuppressWarnings("serial")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = (String) principals.getPrimaryPrincipal(); // 获取用户名

		UserModel userModel=userServer.findByUserName(username);//查询用户
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		List<RoleModel> roleModels=roleServer.findByUserModel(userModel);//查询角色
		
		// 设置角色
		authorizationInfo.setRoles(new HashSet<String>() {
			{
				for (RoleModel roleModel : roleModels) {
					add(roleModel.getRoleName());//添加进shiro角色控制
				}
			}
		});
		// 设置权限
		authorizationInfo.setStringPermissions(new HashSet<String>() {
			{
				//根据角色编号,查询权限
				for (RoleModel roleModel : roleModels) {
					List<PermissionModel> permissionModels=permissionServer.findByRoleModel(roleModel);
					for (PermissionModel permissionModel : permissionModels) {
						add(permissionModel.getPermissionName());//添加进shiro权限控制
					}
				}
			}
		});
		return authorizationInfo;
	}

	// 方法：用来验证当前登录的用户，获取认证信息
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal(); // 获取用户名
		UserModel userModel=userServer.findByUserName(username);
		AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userModel.getUserName(), userModel.getPassword(), "myRealm");
		return authcInfo;
	}

}
