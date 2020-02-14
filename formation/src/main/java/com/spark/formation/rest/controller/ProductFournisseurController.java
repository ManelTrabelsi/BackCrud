package com.spark.formation.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spark.formation.model.entity.Fournisseur;
import com.spark.formation.model.entity.Product;
import com.spark.formation.model.entity.ProductFourn;
import com.spark.formation.model.pk.ProductFournisseurKey;
import com.spark.formation.rest.dto.Fournisseur_productDto;
import com.spark.formation.rest.dto.ProductDto;
import com.spark.formation.service.FournisseurService;
import com.spark.formation.service.Fournisseur_ProductService;
import com.spark.formation.service.ProductService;
import com.spark.formation.service.impl.Fournisseur_Productimp;
@RestController
public class ProductFournisseurController {
	@Autowired
	private Fournisseur_ProductService FournisseurProductService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private FournisseurService fournisseurService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/productFournisseurs")
	public Object productsList() {
		List<ProductFourn> product_Fournisseur = FournisseurProductService.getAllFournisseurProduct();
		Type listType = new TypeToken<List<Fournisseur_productDto>>(){}.getType();
		List<Fournisseur_productDto> Fournisseur_productDto = modelMapper.map(product_Fournisseur, listType);
		return ResponseEntity.status(HttpStatus.OK).body(Fournisseur_productDto);
	}

	
	@GetMapping("/product/{idP}/fournisseur/{idF}/productFournisseurs")
	public Object retrieveProduct_Fournisseur(@PathVariable("idP") Long idP,@PathVariable("idF") Long idF) {
		ProductFourn product_fournisseur = FournisseurProductService.getFournisseurProduct(idP, idF);
		Fournisseur_productDto Fournisseur_productDto = modelMapper.map( product_fournisseur,  Fournisseur_productDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(Fournisseur_productDto);
	}
	
	/**
	 * save Product
	 * @param id
	 * @return
	 */
	@PostMapping("/productFournisseurs")
	public Object addProduct_Fournisseur(@Valid @RequestBody Fournisseur_productDto fournisseur_productDto) {
		ProductFourn product_Fournisseur = modelMapper.map(fournisseur_productDto, ProductFourn.class);
		ProductFournisseurKey productFournisseurKey = new ProductFournisseurKey(fournisseur_productDto.getProductId(), fournisseur_productDto.getFournisseurId());
		product_Fournisseur.setId(productFournisseurKey);
		Product product = productService.getProduct(fournisseur_productDto.getProductId());
		Fournisseur fournisseur = fournisseurService.getFournisseur(fournisseur_productDto.getFournisseurId());
		product_Fournisseur.setProduct(product);
		product_Fournisseur.setFournisseur(fournisseur);
		product_Fournisseur =  FournisseurProductService.saveFournisseurProduct( product_Fournisseur);
		fournisseur_productDto = modelMapper.map(product_Fournisseur, Fournisseur_productDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(fournisseur_productDto) ;
	}
	
	/**
	 * update Product
	 * @param id
	 * @return
	 */
	@PutMapping("/product/{idP}/fournisseur/{idF}/productFournisseurs")
	public Object updateProduct(@Valid @RequestBody Fournisseur_productDto Fournisseur_productDto, @PathVariable("idP") Long idP,@PathVariable("idF") Long idF) {
		ProductFournisseurKey productFournisseurKey = new ProductFournisseurKey(idP,idF);
		ProductFourn product_fournisseur = modelMapper.map(Fournisseur_productDto, ProductFourn.class);
		product_fournisseur.setId(productFournisseurKey);
		
		product_fournisseur = FournisseurProductService.saveFournisseurProduct(product_fournisseur);
		
		Fournisseur_productDto = modelMapper.map(product_fournisseur, Fournisseur_productDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(Fournisseur_productDto);
	}
	
	/**
	 * update Product Quantity
	 * @param id
	 * @return
	 */
	
	
	/**
	 * Delete product
	 * 
	 * @return
	 */
	@DeleteMapping("/product/{idP}/fournisseur/{idF}/productFournisseurs")
	public Object Delete(@PathVariable("idP") Long idP,@PathVariable("idF") Long idF) {
		ProductFournisseurKey productFournisseurKey = new ProductFournisseurKey(idP,idF);

		FournisseurProductService.deleteFournisseurProduct(productFournisseurKey);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}



