package com.desidazzle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/** The product this inventory is of. */
	@JsonIgnore
	@OneToOne(optional = false, orphanRemoval = true)
	@JoinColumn(name = "product_id", nullable = false, unique = true)
	private Product product;

	/** The quantity in stock. */
	@NotBlank(message = "Quantity is required")
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
}
