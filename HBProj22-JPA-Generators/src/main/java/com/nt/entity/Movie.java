//Movie.java		(entity/java bean class)
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
@AllArgsConstructor
@Table(name = "MOVIE_INFO_JPA_GENERATORS")
public class Movie {
	@Id
	@Column(name = "MID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //use with mysql jdbc prop cfg in hibernate.cfg.xml file
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	//use with oracle jdbc prop cfg in hibernate.cfg.xml file
	private Integer mId;
	@Column(name = "MNAME")
	private String mName;
	@Column(name = "HERO")
	private String hero;
	@Column(name = "BUDGET")
	private Float budget;
	
	public Movie() {
		System.out.println("Movie :: 0-param Constructor "+this.getClass());
	}
	

}//class
