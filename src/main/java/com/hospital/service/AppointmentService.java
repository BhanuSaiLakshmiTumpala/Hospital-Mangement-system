package com.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.controller.AppointmentDto;
import com.hospital.entites.Appointment;

@Service
public interface AppointmentService {
	
	
	public List<Appointment> getAllAppointments(String keyword);
	public void saveAppointment(Appointment appointment);
	public Appointment getAppointmentById(long id);
	public void deleteAppointmentId(long id);
	
   public  Appointment save(AppointmentDto appointmentDto);
	

}
