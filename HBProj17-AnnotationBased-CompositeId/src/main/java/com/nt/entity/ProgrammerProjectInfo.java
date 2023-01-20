//ProgrammerProjectInfo.java
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROGRAMMERPROJECTINFO")
public class ProgrammerProjectInfo {
	//HAS-A Property of Id class
	@EmbeddedId
	private PrgmrProjId id;
	@Column(name = "PRGMRNAME",length = 20)
	private String prgmrName;
	@Column(name = "PROJNAME",length = 20)
	private String projName;
	@Column(name = "SALARY")
	private Double salary;
	@Column(name = "BUDGET")
	private Double budget;

}//class
