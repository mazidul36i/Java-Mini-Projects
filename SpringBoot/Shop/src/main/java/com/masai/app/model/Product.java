package com.masai.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	@Size(min = 3, max = 5, message = "Product name must be between 3 to 5 characters!")
	@NotNull(message = "Product name is mandatory!")
	private String productName;
	@Min(1)
	@NotNull(message = "Quantity is mandatory!")
	private Integer quantity;
	@NotNull(message = "Price is mandatory!")
	private Double price;
	@NotNull(message = "Category is mandatory!")
	private String category;
	
}
