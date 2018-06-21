package online.qsx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login doGet");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			currentUser.login(token);
			System.out.println("认证成功");
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/succeed.jsp").forward(request, response);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("认证失败");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}