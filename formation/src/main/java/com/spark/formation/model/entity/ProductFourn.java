package com.spark.formation.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.spark.formation.model.pk.ProductFournisseurKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFourn implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	ProductFournisseurKey id;

	@ManyToOne
	@JoinColumn(name = "Product_id")
	@MapsId("Product_id")
	Product product;

	@ManyToOne
	@JoinColumn(name = "Fournisseur_id")
	@MapsId("Fournisseur_id")
	Fournisseur fournisseur;

}
