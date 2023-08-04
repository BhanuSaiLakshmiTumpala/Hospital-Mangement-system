package com.hospital.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Doctor {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private long id;
	
	
	@Column(name="patient_name")
	private String patientName;
	@Column(name="patient_age")
	private int patientAge;
	
	private String email;
	@Column(name="patient_address")
	private String Address;
	
	private String gender;
	
	@Column(name="patients_phno")
	private int phoneNumber;
	
	private String symptoms;

	public void setId(Long id) {
		this.id = id;
	}


	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public Doctor( String patientName, int patientAge, String email, String address, String gender,
			int phoneNumber, String symptoms) {
		super();
	
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.email = email;
		Address = address;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.symptoms = symptoms;
	}

	public Doctor() {
		super();
	
	}



}
