package com.spark.formation.service;

import java.util.List;

import com.spark.formation.model.entity.Fournisseur;
import com.spark.formation.model.entity.Product;

public interface FournisseurService {
	
	Fournisseur getFournisseur(Long id);
     List<Fournisseur> getAllFournisseur();
	 Fournisseur saveFournisseur(Fournisseur Fournisseur);
     void deleteFournisseur(Long id);
 	Fournisseur updateFournisseurName(Long id, String name);


}
