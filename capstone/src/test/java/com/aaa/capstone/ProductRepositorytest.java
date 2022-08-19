package com.aaa.capstone;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.aaa.capstone.enity.Products;

import com.aaa.capstone.repository.ProductsRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class ProductRepositorytest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProductsRepository productRepo;
	
	@Test
	public void test() {
	Products product = new Products();
	product.setProductName("Wide Screen Monitor");
	product.setUnitprice(349.99);
	product.setProductStock(200);
	product.setProductDesc("32 inch wide-screen LED computer monitor.");
	

	Products savedProduct = getProductRepo().save(product);
	Products existProduct = entityManager.find(Products.class, savedProduct.getProduct_id());

	assertThat(product.getProduct_id()).isEqualTo(existProduct.getProduct_id());
	}

	public ProductsRepository getProductRepo() {
		return productRepo;
	}

	public void setProductRepo(ProductsRepository productRepo) {
		this.productRepo = productRepo;
	}

}
