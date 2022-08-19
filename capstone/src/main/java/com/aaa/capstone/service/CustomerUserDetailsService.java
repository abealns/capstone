package com.aaa.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.aaa.capstone.enity.user;
import com.aaa.capstone.repository.UserRepository;

public class CustomerUserDetailsService implements UserDetailsService {

	 @Autowired
	    private UserRepository userRepo;
	 @Autowired
	    private BCryptPasswordEncoder passwordEncoder;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        user User = userRepo.findByEmail(username);
	        if (User == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new CustUserDetails(User);
	    }
	 
	}