//JobDetails.java (dependent class)
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable		//for component mapping to target entity class
public class JobDetails {
	@Column(name = "DESIGNATION")
	private String desg;
	@Column(name = "COMPANY_NAME")
	private String company;
	@Column
	private Float salary;

}//class
