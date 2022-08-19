package com.aaa.capstone.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.aaa.capstone.enity.user;

@SuppressWarnings("serial")
public class CustUserDetails  implements UserDetails{

	  private user User;
	     
	    public CustUserDetails(user User) {
	        this.User = User;
	    }
	    public String fullName;
	 
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return null;
	    }
	 
	    @Override
	    public String getPassword() {
	        return User.getPassword();
	    }
	 
	    @Override
	    public String getUsername() {
	        return User.getEmail();
	    }
	 
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
	     
	    public String getFullName() {
	        return User.getFirstname() + " " + User.getLastname();
	    }
	 
	}