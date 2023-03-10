//PersonDetails.java (Parent Entity class)
package com.nt.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "ANNO_HB_OTM_PERSON_DETAILS")
public class PersonDetails implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer pid;
	@Column(length = 20)
	private String pname;
	@Column(length = 20)
	private String paddrs;

	//special property to hold bunch of child class Objects (One to Many Association)
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL,
								fetch = FetchType.LAZY, orphanRemoval = true )
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<PhoneNumber> phones;
	
	public PersonDetails() {
		System.out.println("PersonDetails::0-param constructor"+this.getClass());
	}

	@Override
	public String toString() {
		return "PersonDetails [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	

}//class
