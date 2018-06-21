package online.qsx.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	//权限排除登陆方法的调度
	@RequestMapping(value = "user/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(String username,String password,HttpSession session) {
		System.out.println("---------------------->user/login");
		
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			currentUser.login(token);
			System.out.println("认证成功");
			session.setAttribute("username", username);
			return "succeed";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("认证失败");
			return "login";
		}
	}
	
	
	//权限校验,类里面的方法调度
	@RequestMapping(value = "user/studentList", method = { RequestMethod.GET, RequestMethod.POST })
	public String studentList(String username,String password,HttpSession session) {
		System.out.println("---------------------->studentList");
		return "succeed";
	}
	@RequestMapping(value = "user/teacherList", method = { RequestMethod.GET, RequestMethod.POST })
	public String teacherList(String username,String password,HttpSession session) {
		System.out.println("---------------------->teacherList");
		return "succeed";
	}
	@RequestMapping(value = "/user/admin", method = { RequestMethod.GET, RequestMethod.POST })
	public String adminList(String username,String password,HttpSession session) {
		System.out.println("---------------------->adminList");
		return "succeed";
	}

}
