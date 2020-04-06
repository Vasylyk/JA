package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.ParticipantRepository;
import app.domain.Participant;

@Service
public class ParticipantService {
	
	@Autowired
	private ParticipantRepository participantRepository;
	
	public void create (Participant participant) {
		participantRepository.create(participant);
	}
	
	public void deleteById (Integer id) {
		participantRepository.deleteById(id);
	}
	
	public Participant findById (Integer id) {
		return participantRepository.findById(id);
	}
	
	public List<Participant> findAll(){
		return participantRepository.findAll();
	}
	
}
