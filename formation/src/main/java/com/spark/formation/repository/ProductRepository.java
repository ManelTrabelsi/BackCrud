package com.spark.formation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.formation.model.entity.Product;

/**
 * Product Data Access Object
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
