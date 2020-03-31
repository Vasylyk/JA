package app.lesson16;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;

@Configuration
public class Configurations {
	
	@Bean (name = "studentDao")
	public StudentDao getStudentDao() {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao;
	}
	
	@Bean (name = "student")
	public Student getStudent () {
		Student student = new Student();
		student.setId(0);
		student.setName("Taras");
		student.setAge(20);
		return student;
	}
}
