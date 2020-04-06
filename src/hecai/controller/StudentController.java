package hecai.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hecai.entity.Student;
import hecai.service.IStudentService;


@RequestMapping("controller")
@Controller
public class StudentController {
	@Autowired
	@Qualifier("studentService")
	IStudentService studentService;

	
	@RequestMapping("queryStudentByNo/{stuno}")
	public String queryStudentByNo(@PathVariable("stuno") Integer stuNo ,Map<String,Object> map) {
		System.out.println(stuNo);
		Student student = studentService.SelectStudent(6) ;
		map.put("student", student) ;
		return "result" ;
	}  
	
	/**
	 * @param reqeust
	 */
	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletRequest reqeust) {
		System.out.println("Test");
		reqeust.setAttribute("test", "test");
		return "1";
	}
	
//	@RequestMapping("addStudent")
//	public String addStudent(Student student) {
//		System.out.println(student.getStuNo() + "," + student.getStuName()+","+student.getStuAge());
//		studentService.addStudent(student);
//		return "result";
//	}
	
//	@RequestMapping("queryStudentByNo")
//	public ModelAndView queryStudentByNo(HttpServletRequest request) {
//		String stuNo1 = request.getParameter("stuNo");
//		ModelAndView mv = new ModelAndView("result");
//		Student student = studentService.queryStudentByNo(1);
//		mv.addObject("student", student);
//		return mv;
//	}
}
