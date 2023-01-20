//CallerTune.java
package com.nt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Table(name = "CALLERTUNE_ANNO_VER_TS")
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
	@CreationTimestamp
	private Timestamp launchTime;
	@UpdateTimestamp
	private Timestamp lastUpdateTime;

}//class
