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
		// ��ȡ�����ļ�����ʼ��SecurityManager����
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
		// ��ȡsecurityManagerʵ��
		SecurityManager securityManager = factory.getInstance();
		// ��securityManagerʵ���󶨵�SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// �õ���ǰִ�е��û�
		Subject currentUser = SecurityUtils.getSubject();
		// ����token���ƣ��û���/����
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			// �����֤
			currentUser.login(token);
			System.out.println("�����֤�ɹ���");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("�����֤ʧ�ܣ�");
		}
		return currentUser;
	}

	public void testHasRole() {

		String configFile = "classpath:shiro.ini";
		String username = "jack";
		String password = "123456";
		Subject currentUser = login(configFile, username, password);

		// ����hasRole
		System.out.println(currentUser.hasRole("role2") ? "��role2�����ɫ" : "û��role2�����ɫ");

		// ����hasRoles
		boolean[] results = currentUser.hasRoles(Arrays.asList("role1", "role2", "role3"));
		System.out.println(results[0] ? "��role1�����ɫ" : "û��role1�����ɫ");
		System.out.println(results[1] ? "��role2�����ɫ" : "û��role2�����ɫ");
		System.out.println(results[2] ? "��role3�����ɫ" : "û��role3�����ɫ");

		// ����hasAllRoles
		// System.out.println(currentUser.hasAllRoles(Arrays.asList("role1","role2","role3")));

		currentUser.logout();
	}

	public void testCheckRole() {

		String configFile = "classpath:shiro.ini";
		String username = "jack";
		String password = "123456";
		Subject currentUser = login(configFile, username, password);

		currentUser.checkRole("role3");// û�з���ֵ���оͲ�����û�оͻᱨ��
//		currentUser.checkRoles(Arrays.asList("role1", "role2", "role3")); // ͬ��
//		currentUser.checkRoles(Arrays.asList("role1", "role2")); // ͬ��

		currentUser.logout();
	}

	public static void main(String[] args) {
		new TestRoles().testCheckRole();
	}
}
