package app.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import app.dao.ParticipantRepository;
import app.domain.Level;
import app.domain.Participant;

@Repository
public class ParticipantRepositoryImpl implements ParticipantRepository {

	private List<Participant> participants = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		Participant participant1 = new Participant();
		participant1.setId(1);
		participant1.setName("Taras");
		participant1.setEmail("taras@gmail.com");
		participant1.setLevel(Level.L1);
		participant1.setPrimarySkill("someSkill1");

		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("Andriy");
		participant2.setEmail("andriy@gmail.com");
		participant2.setLevel(Level.L2);
		participant2.setPrimarySkill("someSkill2");

		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("Oleg");
		participant3.setEmail("oleg@gmail.com");
		participant3.setLevel(Level.L3);
		participant3.setPrimarySkill("someSkill3");

		participants.add(participant1);
		participants.add(participant2);
		participants.add(participant3);
	}
	
	@Override
	public void create(Participant participant) {
		participant.setId(participants.size()+1);
		participants.add(participant);
	}

	@Override
	public void deleteById(Integer id) {
		Iterator<Participant> iterator = participants.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getId()==id) {
				iterator.remove();
			}
		}
	}

	@Override
	public Participant findById(Integer id) {
		return participants.stream().filter(partisipant -> partisipant.getId() == id).findFirst().orElse(null);
	}

	@Override
	public List<Participant> findAll() {
		return participants;
	}

}
