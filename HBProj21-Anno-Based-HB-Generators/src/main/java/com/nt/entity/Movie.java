//Movie.java		(entity/java bean class)
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "MOVIE_INFO_HB_GENERATORS")
public class Movie {
	@Id
	@Column(name = "MID")
	//@GenericGenerator(name = "gen1", strategy = "increment")
	//@GenericGenerator(name = "gen1", strategy = "identity")
	@GenericGenerator(name = "gen2", strategy = "sequence", 
										parameters = {@Parameter(name = "Sequence_name", value = "NIT_MOVIEID_SEQ1"),
																	@Parameter(name = "initila_value", value = "100"),
																	@Parameter(name = "increment_size", value = "1")} )
	@GeneratedValue(generator = "gen2")
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
