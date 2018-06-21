package online.qsx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//权限控制的角色调度
@Controller
public class TeacherController {

	@RequestMapping(value = "teacher/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String teacherList() {
		System.out.println("---------------------->teacherList");
		return "succeed";
	}

	@RequestMapping(value = "teacher/get", method = { RequestMethod.GET, RequestMethod.POST })
	public String teacherObject() {
		System.out.println("---------------------->teacherObject");
		return "succeed";
	}

	@RequestMapping(value = "teacher/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String teacherEdit() {
		System.out.println("---------------------->teacherEdit");
		return "succeed";
	}

	@RequestMapping(value = "teacher/save", method = { RequestMethod.GET, RequestMethod.POST })
	public String teacherSave() {
		System.out.println("---------------------->teacherSave");
		return "succeed";
	}

	@RequestMapping(value = "teacher/remove", method = { RequestMethod.GET, RequestMethod.POST })
	public String teacherRemove() {
		System.out.println("---------------------->teacherRemove");
		return "succeed";
	}

}
