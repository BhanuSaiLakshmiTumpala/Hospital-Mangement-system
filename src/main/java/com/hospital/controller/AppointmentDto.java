package com.hospital.controller;


public class AppointmentDto {
	
	
	private String patientName;
	
	private int patientAge;
	
	private String email;
	
	private String Address;
	
	private String gender;
	
	private int phoneNumber;
	
	private String symptoms;

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

	public AppointmentDto(String patientName, int patientAge, String email, String address, String gender,
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
	
	


}
