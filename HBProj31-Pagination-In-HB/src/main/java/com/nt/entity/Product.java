//Product.java		(entity/java bean class)
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	private Integer pid;
	@Column(length = 20)
	private String pname;
	private Float price;
	private Float qty;
	

}//class
