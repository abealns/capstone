package com.aaa.capstone;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	 
    private static final long serialVersionUID = 1L;
	private user User;
     
    public CustomUserDetails(user User) {
        this.User = User;
    }
 
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    public String getPassword() {
        return User.getPassword();
    }
 
    public String getUsername() {
        return User.getEmail();
    }
 
    public boolean isAccountNonExpired() {
        return true;
    }
 
    public boolean isAccountNonLocked() {
        return true;
    }
 
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    public boolean isEnabled() {
        return true;
    }
     
    public String getFullName() {
        return User.getFirstname() + " " + User.getLastname();
    }
 
}
