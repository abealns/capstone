package com.aaa.capstone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aaa.capstone.dto.UserResponseDto;
import com.aaa.capstone.enity.Address;
import com.aaa.capstone.enity.user;
import com.aaa.capstone.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	
//	@Autowired
//    private BCryptPasswordEncoder passwordEncoder;

	public user saveUser(user User) {
		return userRepository.save(User);
	}

	public List<user> getAllUsers(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.ASC, "firstName").and(Sort.by(Direction.ASC, "lastName")));
		
		List<user> users = new ArrayList<>();
		List<UserResponseDto> UserResponseDtos = new ArrayList<>();
		
		for(user User :users) {
			UserResponseDto userResponseDto = new UserResponseDto(null, pageSize);
			BeanUtils.copyProperties(User, userResponseDto);
			UserResponseDtos.add(userResponseDto);
		}
		
		return userRepository.findAll(pageable).getContent();
	}

	//public Address getUserById(Long user_id) {

		//return addressRepository.findByUser_id(user_id);
		//userRepository.deleteById(userId);
		/*
		 * Optional<User> user = userRepository.findById(userId); if (user.isPresent())
		 * { return user.get(); }
		 */
	//}

	//@SuppressWarnings("null")
	public user updateuser(Long user_id, user User) {
		user dbUser = null;//getUserById(userId);
		userRepository.delete(dbUser);
		dbUser.setFirstname(User.getFirstname());
		dbUser.setLastname(User.getLastname());
		dbUser.setUsername(User.getUsername());
		return saveUser(dbUser);
	}

	public List<UserResponseDto> getUsersByFirstName(String firstName) {
		return userRepository.getCustomUsers(firstName);
	}

	public List<user> getUsersByNames(String firstName, String lastName) {
		//Pageable pageable = PageRequest.of(0, 5, Sort.by(Direction.ASC, "firstName").and(Sort.by(Direction.ASC, "lastName")));
		//return userRepository.findByFirstNameContainsOrLastNameContainsOrderByFirstNameAsc(firstName, lastName, pageable);
		return userRepository.getUserByNames(firstName, lastName);
	}

	@Override
	public List<user> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getUserById(Long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

//	public BCryptPasswordEncoder getPasswordEncoder() {
//		return passwordEncoder;
//	}
//
//	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
//		this.passwordEncoder = passwordEncoder;
//	}

}