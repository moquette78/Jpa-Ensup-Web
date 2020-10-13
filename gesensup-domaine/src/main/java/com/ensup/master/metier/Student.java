package com.ensup.master.metier;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class Student
 * 
 * @author Student
 *
 */

@Entity
//@Table(name = "person")
public class Student extends Person {

	private String dateOfBirth;
	
	public Student() {
		super();
	}

	public Student(Integer id, String firstName, String lastName, String mailAdresse, String adress, String numberPhone,
			String dateOfBirth) {
		super(id, firstName, lastName, mailAdresse, adress, numberPhone);
		this.dateOfBirth = dateOfBirth;
	}

	
	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	@Override
	public String toString() {
		return "Student [dateOfBirth=" + dateOfBirth + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getMailAdresse()=" + getMailAdresse() + ", getAdress()="
				+ getAdress() + ", getNumberPhone()=" + getNumberPhone() + "]";
	}

}
