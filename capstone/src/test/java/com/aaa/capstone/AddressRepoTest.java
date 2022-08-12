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

public class AddressRepoTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AddressRepository repo;

	@Test
	public void test() {
	Address address = new Address();
	address.setStreet("14533 pensham dr");
	address.setUnit(321);
	address.setCity("Dallas");
	address.setState("Texas");
	address.setZipcode("75035");


	Address savedAddress = repo.save(address);
	Address existAddress = entityManager.find(Address.class, savedAddress.getAddress_id());

	assertThat(address.getUnit()).isEqualTo(existAddress.getUnit());
	}

}
