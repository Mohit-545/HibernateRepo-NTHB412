//CardPayment.java 

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
@DiscriminatorValue(value = "card")
public class CardPayment extends Payment {
	
	private Long cardNo;
	@Column(length = 20)
	private String cardType;
	@Column(length = 20)
	private String gateway;

}//class
