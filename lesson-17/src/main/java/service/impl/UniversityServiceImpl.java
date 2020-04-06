package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UniversityRepository;
import domain.University;
import service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {
	
	@Autowired
	private UniversityRepository universityRepository;
	
	@Override
	public void save(University university) {
		universityRepository.saveAndFlush(university);
	}

	@Override
	public void deleteById(Long id) {
		universityRepository.deleteById(id);
	}

	@Override
	public void update(University university) {
		universityRepository.save(university);
		
	}

	@Override
	public University findById(Long id) {
		return universityRepository.getOne(id);
	}

	@Override
	public University findByName(String name) {
		return universityRepository.findByName(name);
	}

	@Override
	public List<University> findAll() {
		return universityRepository.findAll();
	}

}
