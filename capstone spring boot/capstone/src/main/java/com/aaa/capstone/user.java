package com.aaa.capstone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


@Entity
@Table
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iduser;

	@Column(name = "user_name", unique = true, length = 45)
	@NonNull
	private String userName;

	@Column(name = "password", nullable = false, length = 64)
	private String password;

	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;

	@Column(name = "email", nullable = false, unique = true, length = 45)
	private String email;
	
	@Column(name = "verified", nullable = false, length = 45)
	private int verified;
	
	

	public void setUsername(String userName) {
        this.userName = userName;
    }
    public String getUsername() {
        return this.userName;
    }
   
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
   
    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstname() {
        return this.firstName;
    }
   
    public void setLastname(String lastName) {
        this.lastName = lastName;
    }
    public String getLastname() {
        return this.lastName;
    }
   
    public void setEmail(String email) {
        this.email = email;
    }
    public  String getEmail() {
        return this.email;
    }
   
    public void setId(Long iduser) {
        this.iduser = iduser;
    }
    public Long getId() {
        return this.iduser;
    }
   
    public void setVerified(int verified) {
        this.verified = verified;
    }
    
    public int getVerified() {
    	return this.verified;}

}
