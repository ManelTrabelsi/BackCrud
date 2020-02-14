package com.spark.formation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.formation.model.entity.Fournisseur;
import com.spark.formation.model.entity.ProductFourn;
import com.spark.formation.model.pk.ProductFournisseurKey;
@Repository
public interface FournisseurProductRepository  extends CrudRepository <ProductFourn, ProductFournisseurKey> {
}
