package app.lesson16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import dao.StudentDao;

@SpringBootApplication
public class Lesson16Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Lesson16Application.class, args);
		StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");
		Student student = (Student) ctx.getBean("student");
		Student student2 = new Student();
		student2.setId(1);
		student2.setName("Vadim");
		student2.setAge(22);
		
		studentDao.addStudent(student);
		studentDao.addStudent(student2);
		System.out.println(studentDao.readAll());
		System.out.println(studentDao.readStudent(1));
		studentDao.updateStudent(1, student);
		System.out.println(studentDao.readAll());
		studentDao.removeStudent(1);
		System.out.println(studentDao.readAll());
	}

}
