package service;

import java.util.List;

import domain.University;


public interface UniversityService {
	
	void save (University university);
	
	void deleteById (Long id);
	
	void update (University university);
	
	University findById (Long id);
	
	University findByName (String name);
	
	List<University> findAll();
}
