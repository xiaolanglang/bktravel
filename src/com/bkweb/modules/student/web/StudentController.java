package com.bkweb.modules.student.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bkweb.common.web.BaseController;
import com.bkweb.modules.student.entity.Student;

@Controller
@RequestMapping(value = "${adminPath}/home")
public class StudentController extends BaseController {

	@RequestMapping(value = "index")
	public String index(Model model) {
		model.addAttribute("serverTime", "index");
		
		return "index";
	}

	/**
	 * 
	 * params集合的关系是and
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "index", params = { "path", "image" })
	public String index2(Model model) {

		model.addAttribute("serverTime", "index2");

		return "index";
	}

	/**
	 * @param student
	 *            ModelAttribute("student"),意思就是绑定到model
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "validate")
	public String validate(@ModelAttribute("student") Student student, Model model) {
		validate(model, student);
		return "error/validate";
	}

	@RequestMapping(value = "exception")
	public void exception(Student student, Model model) {
		throw new NullPointerException("空指针异常");
	}

	@RequestMapping(value = "")
	public String list(Model model) {
		Student student = new Student();
		student.setName("张三");
		student.setSex("男");
		student.setSchool("学校一");
		student.setHobby(new String[] { "篮球", "其他" });
		model.addAttribute("student", student);
		return "student/student";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Model model, Student student) {
		model.addAttribute("student", student);
		return "redirect:/home/";
	}

	@RequestMapping(value = "save2", method = RequestMethod.POST)
	public String save2(Model model, Student student) {
		model.addAttribute("student", student);
		return "student/student";
	}

	@ExceptionHandler
	public String exception(HttpServletRequest request, Exception e) {
		request.setAttribute("exception", e);
		return "error/exception";
	}

	@RequestMapping(value = "reda")
	public String redirectAttributes(RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("strs", new String[] { "1", "2", "3", "4" });
		return "redirect:/";
	}

	@RequestMapping(value = "checkbox")
	public String checkBox(String[] id) {
		if (id != null && id.length != 0) {
			for (int i = 0; i < id.length; i++) {
				System.out.println(">>>>>>" + id[i]);
			}
		}
		return "redirect:/";
	}

	@RequestMapping(value = "inputs")
	public String inputs(String[] name) {
		if (name != null && name.length != 0) {
			for (int i = 0; i < name.length; i++) {
				System.out.println(">>>>>>" + name[i]);
			}
		}
		return "redirect:/";
	}

	@RequestMapping(value = "students")
	public String objects(Student students) {
		for (Student student : students.getStudents()) {
			System.out.print("姓名：" + student.getName()+">>>");
			System.out.print("性别：" + student.getSex()+">>>");
			System.out.println("年龄：" + student.getAge());
		}
		return "redirect:/";
	}

}
