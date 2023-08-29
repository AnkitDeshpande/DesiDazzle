package com.desidazzle.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "address_line_1", nullable = false, length = 512)
	private String addressLine1;

	/** The second line of address. */
	@Column(name = "address_line_2", length = 512)
	private String addressLine2;

	/** The city of the address. */
	@NotBlank
	@Column(name = "city", nullable = false)
	private String city;

	/** The country of the address. */
	@NotBlank
	@Column(name = "country", nullable = false, length = 75)
	private String country;

	/** The user the address is associated with. */
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private Customer user;
}
