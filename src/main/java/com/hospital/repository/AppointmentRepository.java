package com.hospital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospital.entites.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	
	@Query("SELECT a FROM Appointment a WHERE a.patientName LIKE %?1%"
			+" OR a.Address LIKE %?1%")
	//where" +"CONCAT (p.patientName,p.patientAge,.....)"+"Like %1?%"
	public List<Appointment> findAll(String keyword);
	
	
	public Appointment findBypatientName(String patientName);
	
	Optional<Appointment> findByEmail(String email); // for test
	
	
	


}
