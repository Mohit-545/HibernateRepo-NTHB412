//Person.java (entity class)
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;


@Data
@Entity
@Table(name = "HB_COMP_PERSON")
public class Person {
	@GeneratedValue
	@Id
	private Integer pid;
	@Column
	private String pname;
	@Column(name = "ADDRESS")
	private String addrs;
	//HAS-A property injected for component mapping
	@Embedded	 	//for mapping component property
	private JobDetails details;

}//class
