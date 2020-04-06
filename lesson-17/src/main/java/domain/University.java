package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column(name = "accreditation_level")
	private int accreditationLevel;
	
	@Column(name = "number_of_instituts")
	private int numberOfInstituts;
	
	@Column(name = "number_of_students")
	private int numberOfStudents;
	
	@Column(name = "address")
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccreditationLevel() {
		return accreditationLevel;
	}

	public void setAccreditationLevel(int accreditationLevel) {
		this.accreditationLevel = accreditationLevel;
	}

	public int getNumberOfInstituts() {
		return numberOfInstituts;
	}

	public void setNumberOfInstituts(int numberOfInstituts) {
		this.numberOfInstituts = numberOfInstituts;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + ", accreditationLevel=" + accreditationLevel
				+ ", numberOfInstituts=" + numberOfInstituts + ", numberOfStudents=" + numberOfStudents + ", address="
				+ address + "]";
	}
	
	
}
