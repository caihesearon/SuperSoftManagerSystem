package hecai.service.impl;

import hecai.entity.Student;
import hecai.mapper.StudentMapper;
import hecai.service.IStudentService;

public class StudentServiceImpl implements IStudentService{

	private StudentMapper studentMapper;
	
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
	
	@Override
	public Student SelectStudent(int id) {
		return studentMapper.queryStudentByStuno(id);
	}
		
}
