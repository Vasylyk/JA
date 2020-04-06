package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import service.UniversityService;
import service.impl.UniversityServiceImpl;

@Configuration
@ComponentScan
public class Configurations {
	
	@Bean (name = "universityService")
	public UniversityService getUniversityService() {
		UniversityService universityService = new UniversityServiceImpl();
		return universityService;
	}
}
