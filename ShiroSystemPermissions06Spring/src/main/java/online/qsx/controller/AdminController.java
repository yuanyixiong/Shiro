package online.qsx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//权限控制的角色调度
@Controller
public class AdminController {
	
	@RequestMapping(value = "admin/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String adminList() {
		System.out.println("---------------------->adminList");
		return "succeed";
	}

	@RequestMapping(value = "admin/get", method = { RequestMethod.GET, RequestMethod.POST })
	public String adminObject() {
		System.out.println("---------------------->adminObject");
		return "succeed";
	}

	@RequestMapping(value = "admin/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String adminEdit() {
		System.out.println("---------------------->adminEdit");
		return "succeed";
	}

	@RequestMapping(value = "admin/save", method = { RequestMethod.GET, RequestMethod.POST })
	public String adminSave() {
		System.out.println("---------------------->adminSave");
		return "succeed";
	}

	@RequestMapping(value = "admin/remove", method = { RequestMethod.GET, RequestMethod.POST })
	public String adminRemove() {
		System.out.println("---------------------->adminRemove");
		return "succeed";
	}
}
