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
@NamedQuery(name = "HQL_GET_PRODUCTS_BY_PRICE_RANGE",
								query = "from Product where price>=:min and price<=:max")
@NamedQuery(name = "INCREASE_PRODUCT_PRICE_BY_PRICE_RANGE",
								query = "update Product set price=price+:newValue where price>=:priceRange")
public class Product {
	@Id
	private Integer pid;
	@Column(length = 20)
	private String pname;
	private Float price;
	private Float qty;
	
	public Product() {
		System.out.println("0-param constructor - Product   :: "+this.hashCode());
	}

}//class
