package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import domain.University;

public interface UniversityRepository extends JpaRepository<University, Long>, CrudRepository<University, Long> {

	University findByName(String name);
	
}
