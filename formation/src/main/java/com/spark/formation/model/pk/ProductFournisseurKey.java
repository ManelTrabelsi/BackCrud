package com.spark.formation.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class ProductFournisseurKey implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "Product_id")
    Long productId;
 
    @Column(name = "Fournisseur_id")
    Long fournisseurId;

}
