package com.ensup.master.metier;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.InheritanceType;

/**
 * Class Person
 * 
 * @author DANON
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private String mailAdresse;
	private String adress;
	private String numberPhone;
	
	public Person() {
		super();
	}
	
	public Person(Integer id, String firstName, String lastName, String mailAdresse, String adress, String numberPhone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailAdresse = mailAdresse;
		this.adress = adress;
		this.numberPhone = numberPhone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMailAdresse() {
		return mailAdresse;
	}

	public void setMailAdresse(String mailAdresse) {
		this.mailAdresse = mailAdresse;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mailAdresse="
				+ mailAdresse + ", adress=" + adress + ", numberPhone=" + numberPhone + "]";
	}
	
}
