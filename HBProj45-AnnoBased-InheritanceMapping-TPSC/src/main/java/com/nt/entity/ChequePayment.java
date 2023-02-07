//ChequePayment.java 

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
@Table(name = "ANNO_INH_CHEQUE_PAYMENT_TPSC")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID", referencedColumnName = "TXID")
public class ChequePayment extends Payment {
	
	private Long chequeNo;
	@Column(length = 20)
	private String chequeType;


}//class
