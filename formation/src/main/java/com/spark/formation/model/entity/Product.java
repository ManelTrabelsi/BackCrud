package com.spark.formation.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Product Model database
 *
 */
@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product implements Serializable {

	/**
	 * generated serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Product id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@SequenceGenerator(name = "product_generator", sequenceName = "Product_SEQ", initialValue = 1, allocationSize = 1)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;
	
	/**
	 * Product name
	 */
	@Column(name = "NAME", length = 50, nullable = false)
	private String name;
	
	/**
	 * Product price
	 */
	@Column(name = "PRICE", nullable = false)
	private Float price;
	
	/**
	 * Product price
	 */
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	 @OneToMany(mappedBy = "product")
	    Set<ProductFourn> productFourns;
}
