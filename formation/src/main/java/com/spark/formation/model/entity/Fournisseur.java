package com.spark.formation.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Fournisseur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fournisseur  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME", length = 50, nullable = false)
	private String name;
	
	@Column(name = "prenom", length = 50, nullable = false)
	private String prenom;

    @OneToMany(mappedBy = "fournisseur")
    Set<ProductFourn> productFourns;
	





}
