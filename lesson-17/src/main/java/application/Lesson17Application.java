package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import domain.University;
import service.UniversityService;

@SpringBootApplication
public class Lesson17Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Lesson17Application.class, args);
		UniversityService universityService = (UniversityService) ctx.getBean("universityService");
		
		University university = new University();
		university.setName("TDMU");
		university.setAccreditationLevel(4);
		university.setNumberOfInstituts(10);
		university.setNumberOfStudents(5000);
		university.setAddress("Ternopil");
		
		University university2 = new University();
		university2.setName("LNU");
		university2.setAccreditationLevel(4);
		university2.setNumberOfInstituts(30);
		university2.setNumberOfStudents(12000);
		university2.setAddress("Lviv");
		
		universityService.save(university);
		universityService.save(university2);
	}

}
