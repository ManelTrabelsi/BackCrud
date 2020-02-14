package com.spark.formation.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@JsonInclude(Include.NON_NULL)
	public class FournisseurDto {
	

		/**
		 * Product id
		 */
		private Long id;

		/**
		 * Product name
		 */
		private String name;
		private String prenom;

	}

