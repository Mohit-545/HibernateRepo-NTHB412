//Movie.java (entity class)
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MOVIE_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
public class Movie {
	@Id	//Singular id field
	@Column(name = "MID")
	private Integer mid;
	@Column(name = "MNAME", length = 20)
	private String mname;
	@Column(name = "HERO", length = 20)
	private String hero;
	@Column(name = "BUDGET")
	//@Transient
	private Float budget;

}//class
