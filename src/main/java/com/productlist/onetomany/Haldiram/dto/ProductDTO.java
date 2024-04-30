package com.productlist.onetomany.Haldiram.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="product")
public class ProductDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
	@Column(nullable = false)
 private String name;
	@Column(nullable=false, unique=true)
 private String category;
 @Column(nullable = false,unique=true)
 private double price;
}
