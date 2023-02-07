//Payment.java 
package com.nt.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


import lombok.Data;


@Data
@Entity
@Table(name = "ANNO_INH_PAYMENT_TPCC")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)  //TPSC
public abstract class Payment {
	@GeneratedValue
	@Id
	private Long txId;
	@Column
	private double amount;
	@Column
	private LocalDateTime txDate;


}//class
