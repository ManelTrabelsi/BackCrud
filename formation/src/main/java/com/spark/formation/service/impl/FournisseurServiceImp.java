package com.spark.formation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.formation.exception.ProductNotFoundException;
import com.spark.formation.model.entity.Fournisseur;
import com.spark.formation.model.entity.Product;
import com.spark.formation.repository.FournisserRepository;
import com.spark.formation.service.FournisseurService;
@Service
public class FournisseurServiceImp implements FournisseurService{

	@Autowired
	private   FournisserRepository fournisseurRepository;

	@Override
	public Fournisseur getFournisseur(Long id) {
		
			Fournisseur Fournisseur = fournisseurRepository.findOne(id);
			return  Fournisseur;
	}

	@Override
	public List<Fournisseur> getAllFournisseur() {
		return (List<Fournisseur>) fournisseurRepository.findAll();	
		
	}

	@Override
	public Fournisseur saveFournisseur(Fournisseur Fournisseur) {
		return fournisseurRepository.save(Fournisseur);	
	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepository.delete(id);		
	}

	@Override
	public Fournisseur updateFournisseurName(Long id, String name) {
		Fournisseur fournisseur = getFournisseur(id);
		return saveFournisseur(fournisseur);
	}
	}


