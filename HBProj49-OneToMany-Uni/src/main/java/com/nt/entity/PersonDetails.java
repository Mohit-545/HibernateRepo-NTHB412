//PersonDetails.java (Parent Entity class)
package com.nt.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class PersonDetails implements Serializable {
	private Integer pid;
	private String pname;
	private String paddrs;
	//special property to hold bunch of child class Objects (One to Many Association)
	private Set<PhoneNumber> phones;

}//class
