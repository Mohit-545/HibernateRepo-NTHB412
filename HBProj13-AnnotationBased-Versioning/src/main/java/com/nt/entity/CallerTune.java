//CallerTune.java
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Data
@Table(name = "CALLERTUNE")
@Entity
public class CallerTune {
	@Id
	@GeneratedValue
	private Integer tuneId;
	@Column(length = 20)
	private String tuneName;
	@Column(length = 20)
	private String movieName;
	@Version	//for Versioning
	private Integer updationCount;

}//class
