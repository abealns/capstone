package com.aaa.capstone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.capstone.enity.Products;
import com.aaa.capstone.repository.ProductsRepository;

@Service
public class ProductService {

	@Autowired  
	ProductsRepository productsRepository;  

	public List<Products> getAllProducts()   
	{  
	List<Products> products = new ArrayList<Products>();  
	productsRepository.findAll().forEach(products1 -> products.add(products1));  
	return products;  
	}  

	public Products getProductsById(int id)   
	{  
	return productsRepository.findById(id).get();  
	}  
	
	public void saveOrUpdate(Products products)   
	{  
		productsRepository.save(products);  
	}  

	public void delete(int id)   
	{  
		productsRepository.deleteById(id);  
	}  

	public void update(Products products, int product_id)   
	{  
		productsRepository.save(products);  
	}  
	}  