//ProgrammerProjectInfo.java
package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammerProjectInfo {
	//HAS-A Property of Id class
	private PrgmrProjId id;
	private String prgmrName;
	private String projName;
	private Double salary;
	private Double budget;

}//class
