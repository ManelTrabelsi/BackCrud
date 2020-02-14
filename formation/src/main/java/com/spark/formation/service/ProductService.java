package com.spark.formation.service;

import java.util.List;

import com.spark.formation.model.entity.Product;

public interface ProductService {

	/**
	 * Get product by ID
	 * 
	 * @param id
	 * @return
	 */
	Product getProduct(Long id);

	/**
	 * Get all product
	 * 
	 * @return
	 */
	List<Product> getAllProduct();
	
	/**
	 * save Product
	 * 
	 * @param product
	 * @return
	 */
	Product saveProduct(Product product);
	

	/**
	 * save Product
	 * 
	 * @param product
	 * @return
	 */
	Product updateProductQuantity(long id, int quantity);

	/**
	 * delete Product
	 * 
	 * @param product
	 */
	void deleteProduct(Long id);


}
