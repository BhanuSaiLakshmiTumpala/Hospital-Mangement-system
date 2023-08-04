package com.hospital;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.hospital.entites.Appointment;
import com.hospital.repository.AppointmentRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 class AppointmentTests {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	//test for saving appointment
	
	@Test
	@Order(1)
	@Rollback(false)
	 void saveAppointmentTest() {
		
		Appointment appointment  = new Appointment("newtest1133", 11, "newtest@gmail.com","chennai" ,
				"male", 23556, "fever,cold");
		appointmentRepository.save(appointment);
		Assertions.assertThat(appointment.getId()).isPositive();
	}
	
	@Test
	@Order(2)
	 void testAppointmentByNameExist() {
    	String name= "newtest1133";
       Appointment appointment = appointmentRepository.findBypatientName(name);
    	
    	assertThat(appointment.getPatientName()).isEqualTo(name);
  }
	
	@Test
	@Order(3)
    void getListOfAppointmentTest() {
		List<Appointment> appointments = appointmentRepository.findAll();
		
		Assertions.assertThat(appointments.size()).isPositive();

	}
	
	@Test
    @Rollback(false)
    @Order(4)
    void testUpdateAppointment() {
    	String patientName = "new";
    	Appointment appointment  = new Appointment(patientName, 11, "newtest@gmail.com","chennai" ,
				"male", 23556, "fever,cold");
    	   appointment.setId(1);
    	  appointmentRepository.save(appointment);
    	   
    	 Appointment updatedAppointment = appointmentRepository.findBypatientName(patientName);
    	 
    	 assertThat(updatedAppointment.getPatientName()).isEqualTo(patientName);
    	 
    }
	
//	@Test
//    @Rollback(false)
//    @Order(5)
//     void testDeleteAppointment() {
//    	
//    	long id= 1;
//    	
//    	boolean isExistBeforeDeleting = appointmentRepository.findById(id).isPresent();    	
//    	appointmentRepository.deleteById(id);
//    	
//    	boolean isExistAfterDeleting  = appointmentRepository.findById(id).isPresent();
//    	
//    	org.junit.jupiter.api.Assertions.assertTrue(isExistBeforeDeleting);
//    	org.junit.jupiter.api.Assertions.assertFalse(isExistAfterDeleting);
//    	
//    }

}
