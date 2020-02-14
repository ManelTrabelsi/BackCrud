package com.spark.formation.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.formation.model.entity.ProductFourn;
import com.spark.formation.model.pk.ProductFournisseurKey;
import com.spark.formation.repository.FournisseurProductRepository;
import com.spark.formation.service.Fournisseur_ProductService;
@Service
public class Fournisseur_Productimp implements Fournisseur_ProductService {
	@Autowired
	private FournisseurProductRepository fournisseurProductRepository;


	@Override
	public ProductFourn getFournisseurProduct(Long idP, Long idF) {
		ProductFournisseurKey productFournisseurKey=new ProductFournisseurKey(idP, idF);
		ProductFourn Product_Fournisseur = fournisseurProductRepository.findOne(productFournisseurKey);
		return  Product_Fournisseur;
		
	}

	@Override
	public List<ProductFourn> getAllFournisseurProduct() {
			return (List<ProductFourn>)fournisseurProductRepository.findAll();		
	}

	@Override
	public ProductFourn saveFournisseurProduct(ProductFourn productFourn ) {
		
		return fournisseurProductRepository.save(productFourn);	
	}

	@Override
	public void deleteFournisseurProduct(ProductFournisseurKey productFournisseurKey) {
		fournisseurProductRepository.delete(productFournisseurKey);		
	}

	

}
