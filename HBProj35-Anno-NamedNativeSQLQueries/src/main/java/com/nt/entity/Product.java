//Product.java		(entity/java bean class)
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT")
@NamedNativeQuery(name = "GET_PRODUCTS_BY_PRICE_RANGE",
											query = "select * from Product where price>=? and price<=?",
											resultClass = Product.class)
@NamedNativeQuery(name = "HIKE_PRICE_BY_PRODUCT_NAME",
											query = "update Product set price=price+? where pname=?")
public class Product {
	@Id
	private Integer pid;
	@Column(length = 20)
	private String pname;
	@Column
	private Float price;
	@Column
	private Float qty;

}//class
