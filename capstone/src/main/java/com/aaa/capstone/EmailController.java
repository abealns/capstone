package com.aaa.capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.aaa.capstone.service.EmailService;


@Controller
public class EmailController {
	
	 @Autowired
	    private EmailService emailService;

	    @GetMapping(value = "/sendmail")
	    public String sendmail() {

	        emailService.sendMail("kate@example.com", "Test Subject", "Test mail");

	        return "emailsent";
	    }
	}

