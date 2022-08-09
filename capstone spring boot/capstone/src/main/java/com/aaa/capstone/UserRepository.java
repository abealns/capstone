package com.aaa.capstone;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<user, Long>{
	@Query("SELECT u FROM user u WHERE u.email = ?1")
 
	//public user findByEmail(String userName);

	public user findByEmail(String userName);
     
     

}