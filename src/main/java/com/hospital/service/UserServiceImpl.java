package com.hospital.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hospital.controller.UserRegistrationDTO;
import com.hospital.entites.Role;
import com.hospital.entites.User;
import com.hospital.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User save(UserRegistrationDTO userRegistration) {
		User user = new User(userRegistration.getFirstname(),
				userRegistration.getLastname(),passwordEncoder.encode(userRegistration.getPassword()), 
				userRegistration.getEmail()
				, Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user =userRepository.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Inavlid Username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), mapRolesToAuthorities(user.getRoles()));
		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		 
			  return roles.stream().map(role->
                            new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
          }

}
