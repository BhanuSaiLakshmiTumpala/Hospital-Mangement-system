package com.hospital.entites;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	
	
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		private Long id;
		
		 
	      private String firstname;
	      
	      
	      private String lastname;

		  
	      private String password;
	     
	      private String email;
	      
	      @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	      @JoinTable(
	    		  name="user_roles",
	    		  joinColumns=@JoinColumn(name="user_id",referencedColumnName = "id"),
	    		  inverseJoinColumns = @JoinColumn(
	    				  name="role_id",referencedColumnName = "id") )
	     private Collection<Role> roles;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Collection<Role> getRoles() {
			return roles;
		}

		public void setRoles(Collection<Role> roles) {
			this.roles = roles;
		}

		public User( String firstname, String lastname, String password, String email, Collection<Role> roles) {
			super();
		
			this.firstname = firstname;
			this.lastname = lastname;
			this.password = password;
			this.email = email;
			this.roles = roles;
		}

		public User() {
			super();
			
		}
          
         
		  
	    
	    
	    


}
