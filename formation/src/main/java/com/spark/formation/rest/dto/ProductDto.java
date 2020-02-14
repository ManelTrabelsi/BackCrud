package com.spark.formation.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Product Json object
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ProductDto {

	/**
	 * Product id
	 */
	private Long id;

	/**
	 * Product name
	 */
	private String name;
	
	/**
	 * Product price
	 */
	private float price;

	/**
	 * Product quantity
	 */
	private int quantity;

}
