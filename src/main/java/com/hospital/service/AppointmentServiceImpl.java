package com.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.controller.AppointmentDto;
import com.hospital.entites.Appointment;
import com.hospital.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl  implements AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public List<Appointment> getAllAppointments(String keyword) {
		if(keyword !=null) {
			return appointmentRepository.findAll(keyword);
			
			
			
		}
		return appointmentRepository.findAll();
		
	}


	@Override
	public void saveAppointment(Appointment appointment) {
		
		this.appointmentRepository.save(appointment);
		
		
	}

	@Override
	public Appointment getAppointmentById(long id) {
		Optional<Appointment> optional = appointmentRepository.findById(id);
		
        Appointment appointment = null;
        
        if(optional.isPresent()) {
       	 
          appointment=optional.get();
          
          }
       
        return appointment;
        }


	@Override
	public void deleteAppointmentId(long id) {
		
		this.appointmentRepository.deleteById(id);
		
	}


	@Override
	public Appointment save(AppointmentDto appointmentDto) {
		
	  Appointment appointment  = new Appointment(appointmentDto.getPatientName(),appointmentDto.getPatientAge(),appointmentDto.getEmail()
			  ,appointmentDto.getAddress(), appointmentDto.getGender(), appointmentDto.getPhoneNumber(), appointmentDto.getSymptoms());
		
	  return appointmentRepository.save(appointment);
	}

}
