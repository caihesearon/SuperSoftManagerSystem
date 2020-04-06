package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hecai.entity.Student;
import hecai.service.IStudentService;
import hecai.service.ITaskService;

public class test {

	public static void main(String[] args) {
//		System.out.println("Test");
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		IStudentService is = (IStudentService)context.getBean("studentService");
//		Student student = is.SelectStudent(6);
//		System.out.println(student.getStuName());
		
		ITaskService it = (ITaskService)context.getBean("taskService");
		int addTask = it.AddTask("1999-12-18");
		System.out.println(addTask);
		
	}
	
}
