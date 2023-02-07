//ChequePayment.java 

package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "cheque")
public class ChequePayment extends Payment {
	
	private Long chequeNo;
	@Column(length = 20)
	private String chequeType;


}//class
