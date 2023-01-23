//Product.java
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer pid;
	@Column
	private String pname;
	@Column
	private Double price;
	@Column
	private Double qty;

}//class
