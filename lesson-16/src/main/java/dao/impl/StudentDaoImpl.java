package dao.impl;

import java.util.ArrayList;
import java.util.List;

import app.lesson16.Student;
import dao.StudentDao;

public class StudentDaoImpl implements StudentDao{
	
	List<Student> students = new ArrayList<>(); 
	
	@Override
	public void addStudent(Student student) {
		students.add(student);
		
	}

	@Override
	public void removeStudent(int id) {
		students.remove(id);
		
	}

	@Override
	public void updateStudent(int id, Student student) {
		students.get(id).setId(student.getId());
		students.get(id).setName(student.getName());
		students.get(id).setAge(student.getAge());
		
	}

	@Override
	public Student readStudent(int id) {
		return students.get(id);
		
	}

	@Override
	public List<Student> readAll() {
		return students;
	}

}
