package dao;

import java.util.List;

import app.lesson16.Student;

public interface StudentDao {
	void addStudent(Student student);
	
	void removeStudent (int id);
	
	void updateStudent (int id, Student student);
	
	Student readStudent (int id);
	
	List<Student> readAll();
	
}
