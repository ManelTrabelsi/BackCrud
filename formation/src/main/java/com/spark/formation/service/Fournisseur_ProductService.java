package com.spark.formation.service;

import java.util.List;

import com.spark.formation.model.entity.ProductFourn;
import com.spark.formation.model.pk.ProductFournisseurKey;

public interface Fournisseur_ProductService {
	
	ProductFourn getFournisseurProduct(Long idP,Long idF);
    List<ProductFourn> getAllFournisseurProduct();
    ProductFourn saveFournisseurProduct(ProductFourn productFourn);
    
    void deleteFournisseurProduct(ProductFournisseurKey productFournisseurKey);

}
