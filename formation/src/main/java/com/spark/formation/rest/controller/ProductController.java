
package com.spark.formation.rest.controller;

import java.lang.reflect.Type;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spark.formation.model.entity.Product;
import com.spark.formation.rest.dto.ProductDto;
import com.spark.formation.service.ProductService;


@RestController()
public class ProductController {

	/**
	 * Product Service
	 */
	@Autowired
	private ProductService productService;

	/**
	 * Model Mapper
	 */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * get all product
	 * @return
	 */
	@GetMapping("/products")
	public Object productsList() {
		List<Product> products = productService.getAllProduct();
		Type listType = new TypeToken<List<ProductDto>>(){}.getType();
		List<ProductDto> productDtos = modelMapper.map(products, listType);
		return ResponseEntity.status(HttpStatus.OK).body(productDtos);
	}

	/**
	 * get Product by id
	 * @param id
	 * @return
	 */
	@GetMapping("/products/{id}")
	public Object retrieveProduct(@PathVariable long id) {
		Product product = productService.getProduct(id);
		ProductDto productDto = modelMapper.map( product,  ProductDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(productDto);
	}
	
	/**
	 * save Product
	 * @param id
	 * @return
	 */
	@PostMapping("/products")
	public Object addProduct(@Valid @RequestBody ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		
		product = productService.saveProduct(product);

		productDto = modelMapper.map(product, ProductDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
	}
	
	/**
	 * update Product
	 * @param id
	 * @return
	 */
	@PutMapping("/products/{id}")
	public Object updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable long id) {
		Product product = modelMapper.map(productDto, Product.class);
		product.setId(id);
		
		product = productService.saveProduct(product);
		
		productDto = modelMapper.map(product, ProductDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	/**
	 * update Product Quantity
	 * @param id
	 * @return
	 */
	@PatchMapping("/products/{id}")
	public Object updateProductQuantity(@Valid @RequestBody ProductDto productDto, @PathVariable long id) {
		Product product = productService.updateProductQuantity(id, productDto.getQuantity());
		productDto = modelMapper.map(product, ProductDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
	}
	
	/**
	 * Delete product
	 * 
	 * @return
	 */
	@DeleteMapping("/products/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
