//Person.java (entity class)
package com.nt.entity;

import lombok.Data;

@Data
public class Person {
	private Integer pid;
	private String pname;
	private String addrs;
	//HAS-A property injected for component mapping
	private JobDetails details;

}//class
