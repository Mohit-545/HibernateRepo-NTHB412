//Product.java
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCT")
public class Product {
	@Id
	private Integer pid;
	@Column(length = 20)
	private String pname;
	@Column
	private double price;
	@Column
	private double qty;

}//class
