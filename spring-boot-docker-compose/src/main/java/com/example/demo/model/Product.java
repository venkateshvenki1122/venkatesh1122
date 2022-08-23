package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "venki_products_post")
public class Product {

	@Id
	@Column(name = "product_id")
	int productId;
	
	@Column(name = "product_name")
	String productName;
	
	@Column(name = "rate_per_unit")
	double ratePerUnit;
}
