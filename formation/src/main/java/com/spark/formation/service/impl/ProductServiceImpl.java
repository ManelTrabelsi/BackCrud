package com.spark.formation.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spark.formation.exception.ProductNotFoundException;
import com.spark.formation.model.entity.Product;
import com.spark.formation.repository.ProductRepository;
import com.spark.formation.service.ProductService;

/**
 * Product Service
 */
@Service
public class ProductServiceImpl implements ProductService {

	/**
	 * product Repository
	 */
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Product getProduct(Long id) {
		Product product = productRepository.findOne(id);
		if(product == null) {
			throw new ProductNotFoundException();
		}
		return product;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Product> getAllProduct() {
		return (List<Product>) productRepository.findAll();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void deleteProduct(Long id) {
		try {
			productRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ProductNotFoundException();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Product updateProductQuantity(long id, int quantity) {
		Product product = getProduct(id);
		product.setQuantity(quantity);
		return saveProduct(product);
	}
}
