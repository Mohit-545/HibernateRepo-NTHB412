//CardPayment.java 

package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ANNO_INH_CARD_PAYMENT_TPSC")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID", referencedColumnName = "TXID")
public class CardPayment extends Payment {
	
	private Long cardNo;
	@Column(length = 20)
	private String cardType;
	@Column(length = 20)
	private String gateway;

}//class
