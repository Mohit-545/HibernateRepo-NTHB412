//Customer.java (subclass 1)
package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Person {
	private Integer billNo;
	private Double billAmt;
	

}//class
