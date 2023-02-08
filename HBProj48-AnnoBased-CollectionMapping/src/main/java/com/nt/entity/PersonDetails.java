//PersonDetails.java (Entity class)
package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;

@Data
@Entity
@Table(name = "HB_ANNO_PER_DETAILS_COLLECTION")
public class PersonDetails {
	@Id
	@GeneratedValue
	private Integer pid;
	@Column
	private String pname;
	@Column
	private String paddrs;
	
	@ElementCollection
	@CollectionTable(name = "HB_ANNO_PER_NICKNAMES_COLLECTION",
									joinColumns = @JoinColumn(name = "PERSON_ID",referencedColumnName = "PID"))
	@Column(name = "NICKNAME", length = 10)
	@OrderColumn(name = "NNAME_INDX")
	@ListIndexBase(value = 1)
	private List<String> nickNames;
	
	@ElementCollection
	@CollectionTable(name = "HB_ANNO_PER_FRIENDS_COLLECTION",
									joinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "PID"))
	@Column(name = "FRIEND", length = 10)
	private List<String> friends;
	
	@ElementCollection
	@CollectionTable(name = "HB_ANNO_PER_CONTACT_COLLECTION",
									joinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "PID"))
	@Column(name = "CONTACT_NUMBER", length = 15)
	private Set<Long> contactNumbers;
	
	@ElementCollection
	@CollectionTable(name = "HB_ANNO_PER_IDDETAILS_COLLECTION",
									joinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "PID"))
	@MapKeyColumn(name = "IDTYPE", length = 20)
	@Column(name = "ID_NUMBER", length = 20)
	private Map<String, Long> idDetails;
	

}//class
