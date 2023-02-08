//PhoneNumber.java (Child entity class)
package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class PhoneNumber implements Serializable {
	private Integer regNo;
	private Long mobileNo;
	private String numberType;
	private String provider;

}//class
