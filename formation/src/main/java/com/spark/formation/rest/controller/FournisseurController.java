package com.spark.formation.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spark.formation.model.entity.Fournisseur;
import com.spark.formation.rest.dto.FournisseurDto;
import com.spark.formation.service.impl.FournisseurServiceImp;

@CrossOrigin("*")
@RestController()
public class FournisseurController {
	@Autowired
	private FournisseurServiceImp FournisseurService;

	/**
	 * Model Mapper
	 */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * get all product
	 * @return
	 */
	@GetMapping("/fournisseurs")
	public Object FournisseurList() {
		List<Fournisseur> fournisseur = FournisseurService.getAllFournisseur();
		Type listType = new TypeToken<List<FournisseurDto>>(){}.getType();
		List<FournisseurDto> fournisseurDtos = modelMapper.map(fournisseur, listType);
		return ResponseEntity.status(HttpStatus.OK).body(fournisseurDtos);
	}

	
	@GetMapping("/fournisseurs/{id}")
	public Object retrieveFournisseur(@PathVariable long id) {
		Fournisseur fournisseur = FournisseurService.getFournisseur(id);
		FournisseurDto fournisseurDto = modelMapper.map( fournisseur,  FournisseurDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(fournisseurDto);
	}
	
	/**
	 * save Product
	 * @param id
	 * @return
	 */
	@PostMapping("/fournisseurs")
	public Object addFornisseur(@Valid @RequestBody FournisseurDto fournisseurDto) {
		Fournisseur fournisseur = modelMapper.map(fournisseurDto, Fournisseur.class);
		
		fournisseur = FournisseurService.saveFournisseur(fournisseur);

		fournisseurDto = modelMapper.map(fournisseur, FournisseurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(fournisseurDto);
	}
	
	/**
	 * update Product
	 * @param id
	 * @return
	 */
	@PutMapping("/fournisseurs/{id}")
	public Object updateProduct(@Valid @RequestBody FournisseurDto fournisseurDto, @PathVariable long id) {
		Fournisseur fournisseur = modelMapper.map(fournisseurDto, Fournisseur.class);

		fournisseur.setId(id);
		
		fournisseur =FournisseurService.saveFournisseur(fournisseur);
		
		fournisseurDto = modelMapper.map(fournisseur, FournisseurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(fournisseur);
	}
	
	/**
	 * update Product Quantity
	 * @param id
	 * @return
	 */
	@PatchMapping("/fournisseurs/{id}")
	public Object updatefournisseurQuantity(@Valid @RequestBody  FournisseurDto fournisseurDto, @PathVariable long id) {
		Fournisseur fournisseur =  FournisseurService.updateFournisseurName(id, fournisseurDto.getName());
		fournisseurDto = modelMapper.map(fournisseur, FournisseurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(fournisseurDto);

	}
	
	
	@DeleteMapping("/fournisseurs/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		FournisseurService.deleteFournisseur(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}


}
