package com.aaa.capstone.repository;



import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aaa.capstone.dto.UserResponseDto;
import com.aaa.capstone.enity.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long>{
	

	@Query("SELECT u FROM user u WHERE u.email = ?1")
	user findByEmail(String email);
 
	List<user> findByFirstName(String firstName); 
	
	List<user> findByFirstNameContains(String firstName); 
	
	List<user> findByFirstNameAndLastName(String firstName, String lastName);

	
	
	@Query(value = "select u.* from user u where u.first_name=:firstName and u.last_name = :lastName", nativeQuery = true)
	
	List<user> getUserByNames(String firstName, String lastName);
	
	List<user> findByFirstNameOrLastName(String firstName, String lastName);
	
	List<user> findByFirstNameContainsOrLastNameContains(String firstName, String lastName);

	//List<user> findAll(Long user_id, String email, String firstName, String lastName);


	List<user> findByFirstNameContainsOrLastNameContainsOrderByFirstNameAsc(String firstName,
			String lastName);

	List<user> findByFirstNameContains(String firstName, Pageable pageable);

	List<user> findByFirstNameContainsOrLastNameContainsOrderByFirstNameAsc(String firstName, String lastName,
			Pageable pageable);
	
	@Query("select new com.aaa.capstone.dto.UserResponseDto(firstName, count(*)) from user where firstName=:firstName")
	List<UserResponseDto> getCustomUsers(@Param("firstName") String firstName);

     
     

}