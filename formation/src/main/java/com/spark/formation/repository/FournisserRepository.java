package com.spark.formation.repository;

import org.springframework.data.repository.CrudRepository;

import com.spark.formation.model.entity.Fournisseur;
import com.spark.formation.model.pk.ProductFournisseurKey;

public interface FournisserRepository extends CrudRepository <Fournisseur, Long>  {
}
