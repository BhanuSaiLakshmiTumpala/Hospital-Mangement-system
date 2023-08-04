package com.hospital.controller;

import org.apache.log4j.Logger;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.entites.Appointment;
import com.hospital.service.AppointmentService;

@Controller
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	 static Logger logger = Logger.getLogger(AppointmentController.class);
	 static final String LOG_PROPERTIES_FILE = "log4j.properties";
	 
	   
	public AppointmentController(AppointmentService appointmentService) {
		super();
		this.appointmentService = appointmentService;
	}
	
	//book appointment
		@GetMapping("/user/newAppointment")
		public String addNewAppointment(Model model) {
			 logger.info("addNewAppointment method is called ");
			Appointment appointment = new Appointment();
			model.addAttribute("appointment", appointment);
			return "new_appointment";
				
		}
        @GetMapping("/update_appoinment")
		public String update(){
			return "update_appointment";
		}
	  
		@PostMapping("/user/saveAppointment")
		public String savePatient(@ModelAttribute("appointment") AppointmentDto appointmentDto ) {
			logger.info("saveAppointment is called");
			
			appointmentService.save(appointmentDto);
			return "home";
	}   
		
		@RequestMapping("/showFormForUpdate/{id}")
		public String updateDetails(@PathVariable(value="id") long id,Model model) {
			
			logger.info("updateDetails method is called ");
			Appointment appointment = appointmentService.getAppointmentById(id);
			
			model.addAttribute("appointment", appointment);
			return "update_appointment";	
		}
		
		@RequestMapping("/list")
		public String viewHomePage(Model model,@Param("keyword") String keyword) {
                
			logger.info("Returned list of appointments ");
	        	model.addAttribute( "listAppointments",appointmentService.getAllAppointments(keyword));
	        	
	        	model.addAttribute("keyword", keyword);
			
			     return "appointmentslist";
		}
		
		@RequestMapping("/deleteAppointment/{id}")
		public String deletePatient(@PathVariable(value="id" ) long id) {
			logger.info("deleteAppointment method is called ");
			// call del from service
			this.appointmentService.deleteAppointmentId(id);
			return "appointmentslist";
		
		}
		
		@GetMapping("/accessDenied")
		public String error() {
			logger.info("access denied page is called");
			return "access-denied";
		}

		
	

}
