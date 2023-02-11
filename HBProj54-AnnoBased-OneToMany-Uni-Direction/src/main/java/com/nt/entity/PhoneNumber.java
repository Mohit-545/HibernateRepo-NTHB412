//PhoneNumber.java (Child entity class)
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
@Table(name = "ANNO_HB_OTM_PHONE_NUMBER")
public class PhoneNumber implements Serializable {
	@Id
	@SequenceGenerator(name = "generator1", sequenceName = "PHONE_SEQ", allocationSize = 100, initialValue = 1)
	@GeneratedValue(generator = "generator1",strategy = GenerationType.SEQUENCE)
	private Integer regNo;
	@Column(length = 15)
	private Long mobileNo;
	@Column(length = 15)
	private String numberType;
	@Column(length = 15)
	private String provider;
	
	public PhoneNumber() {
		System.out.println("PhoneNumber::0-param constructor"+this.getClass());
	}

	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", mobileNo=" + mobileNo + ", numberType=" + numberType + ", provider="
				+ provider + "]";
	}
	
	

}//class
