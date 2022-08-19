package com.aaa.capstone.service;

import java.util.List;


import com.aaa.capstone.enity.Address;
import com.aaa.capstone.enity.user;
import com.aaa.capstone.dto.UserResponseDto;

public interface UserService {

	public user saveUser(user User);

	public List<user> getAllUsers();

	public Address getUserById(Long user_id);

	public user updateuser(Long user_id, user User);

	public List<UserResponseDto> getUsersByFirstName(String firstName);

	public List<user> getUsersByNames(String firstName, String lastName);

	List<user> getAllUsers(int pageNumber, int pageSize);

}