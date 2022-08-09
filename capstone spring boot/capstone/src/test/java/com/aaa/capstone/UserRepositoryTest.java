package com.aaa.capstone;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class UserRepositoryTest {

@Autowired
private TestEntityManager entityManager;

@Autowired
private UserRepository repo;

@Test
public void test() {
user User = new user();
User.setUsername("JohnJohn255");
User.setPassword("Password");
User.setFirstname("John");
User.setLastname("Smith");
User.setEmail("johnsmith2001@gmail.com");
User.setVerified(1);

user savedUser = repo.save(User);
user existUser = entityManager.find(user.class, savedUser.getId());

assertThat(User.getEmail()).isEqualTo(existUser.getEmail());
}

}
