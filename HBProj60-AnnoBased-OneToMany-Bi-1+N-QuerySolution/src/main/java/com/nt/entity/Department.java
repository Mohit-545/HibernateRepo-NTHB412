//Department.java (Parent class)
package com.nt.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "ANNO_HB_DEPARTMENT")
public class Department  {
	@Id
	@GeneratedValue
	private Integer deptNo;
	@Column(length = 15)
	private String deptName;
	@Column(length = 15)
	private String deptHead;
	
	//special property to hold bunch of child class Objects (One to Many Association)
	@OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL, 
								orphanRemoval = true,fetch = FetchType.LAZY, mappedBy = "dept")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Employee> employees;
	
	public Department() {
		System.out.println("Department :: 0-param constructor "+this.getClass());
	}
	
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}

}//class
