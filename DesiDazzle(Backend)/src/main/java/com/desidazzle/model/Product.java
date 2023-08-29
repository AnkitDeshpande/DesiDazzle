package com.desidazzle.model;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	/** Unique id for the product. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/** The name of the product. */
	@NotBlank(message = "Product name is required")
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	/**
	 * The image of Product
	 */
	@NotBlank(message = "image name is required")
	@URL
	private String image;

	/** The short description of the product. */
	@NotBlank(message = "Product description is required")
	@Column(name = "short_description", nullable = false)
	private String shortDescription;

	/** The long description of the product. */
	@Column(name = "long_description")
	private String longDescription;

	/** The price of the product. */
	@NotBlank(message = "Price is required")
	@DecimalMin(value = "0.0", message = "Price must be greater than or equal to 0")
	@Column(name = "price", nullable = false)
	private Double price;

	/** The inventory of the product. */
	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
	private Inventory inventory;
}
