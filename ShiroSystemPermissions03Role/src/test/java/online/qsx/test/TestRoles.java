package online.qsx.test;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class TestRoles {
	public Subject login(String configFile, String username, String password) {
		// 读取配置文件，初始化SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
		// 获取securityManager实例
		SecurityManager securityManager = factory.getInstance();
		// 把securityManager实例绑定到SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// 得到当前执行的用户
		Subject currentUser = SecurityUtils.getSubject();
		// 创建token令牌，用户名/密码
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			// 身份认证
			currentUser.login(token);
			System.out.println("身份认证成功！");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("身份认证失败！");
		}
		return currentUser;
	}

	public void testHasRole() {

		String configFile = "classpath:shiro.ini";
		String username = "jack";
		String password = "123456";
		Subject currentUser = login(configFile, username, password);

		// 测试hasRole
		System.out.println(currentUser.hasRole("role2") ? "有role2这个角色" : "没有role2这个角色");

		// 测试hasRoles
		boolean[] results = currentUser.hasRoles(Arrays.asList("role1", "role2", "role3"));
		System.out.println(results[0] ? "有role1这个角色" : "没有role1这个角色");
		System.out.println(results[1] ? "有role2这个角色" : "没有role2这个角色");
		System.out.println(results[2] ? "有role3这个角色" : "没有role3这个角色");

		// 测试hasAllRoles
		// System.out.println(currentUser.hasAllRoles(Arrays.asList("role1","role2","role3")));

		currentUser.logout();
	}

	public void testCheckRole() {

		String configFile = "classpath:shiro.ini";
		String username = "jack";
		String password = "123456";
		Subject currentUser = login(configFile, username, password);

		currentUser.checkRole("role3");// 没有返回值。有就不报错，没有就会报错
//		currentUser.checkRoles(Arrays.asList("role1", "role2", "role3")); // 同上
//		currentUser.checkRoles(Arrays.asList("role1", "role2")); // 同上

		currentUser.logout();
	}

	public static void main(String[] args) {
		new TestRoles().testCheckRole();
	}
}
