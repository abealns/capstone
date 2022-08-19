package com.aaa.capstone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaa.capstone.enity.Products;
import com.aaa.capstone.service.ProductService;

@RestController
public class ProductController {

	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	private List<Products>getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{product_id}")
	private Products getProducts(@PathVariable("product_id") int product_id) {
		return productService.getProductsById(product_id);
	}
	
	@DeleteMapping("/products/{product_id}")  
	private void deleteProduct(@PathVariable("product_id") int product_id)   
	{  
	productService.delete(product_id);  
	}  

	@PostMapping("/products")  
	private int saveProduct(@RequestBody Products products)   
	{  
	productService.saveOrUpdate(products);  
	return products.getProduct_id();  
	}  
	 
	@PutMapping("/products")  
	private Products update(@RequestBody Products products)   
	{  
	productService.saveOrUpdate(products);  
	return products;  
	} 
	
}
