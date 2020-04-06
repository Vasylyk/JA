package app.dao;

import java.util.List;

import app.domain.Participant;

public interface ParticipantRepository {
	public void create (Participant participant);
	
	public void deleteById (Integer id);
	
	public Participant findById (Integer id);
	
	public List<Participant> findAll ();
}
