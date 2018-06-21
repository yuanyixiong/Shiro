package online.qsx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//权限控制的角色调度
@Controller
public class StudentController {
	
	@RequestMapping(value = "student/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String studentList() {
		System.out.println("---------------------->studentList");
		return "succeed";
	}

	@RequestMapping(value = "student/get", method = { RequestMethod.GET, RequestMethod.POST })
	public String studentObject() {
		System.out.println("---------------------->studentObject");
		return "succeed";
	}

	@RequestMapping(value = "student/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String studentEdit() {
		System.out.println("---------------------->studentEdit");
		return "succeed";
	}

	@RequestMapping(value = "student/save", method = { RequestMethod.GET, RequestMethod.POST })
	public String studentSave() {
		System.out.println("---------------------->studentSave");
		return "succeed";
	}

	@RequestMapping(value = "student/remove", method = { RequestMethod.GET, RequestMethod.POST })
	public String studentRemove() {
		System.out.println("---------------------->studentRemove");
		return "succeed";
	}

}
