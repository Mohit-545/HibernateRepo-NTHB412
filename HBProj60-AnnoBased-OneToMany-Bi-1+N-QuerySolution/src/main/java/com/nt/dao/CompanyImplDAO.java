//CompanyImplDAO.java
package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.utils.HibernateUtil;

public class CompanyImplDAO implements ICompanyDAO {

		// Solution (1) -> Using Joins Concept to avoid 1+N Query generation problem
		@Override
		public void loadDataUsingJoinsParentToChild() {
			Session ses = HibernateUtil.getSession();
			try(ses){
				Query query = ses.createQuery("select d.deptNo,d.deptName,d.deptHead,e.empNo,e.empName,e.empSalary from Department d inner join d.employees e");
				List<Object[]> list = query.getResultList();
				list.forEach(row->{
					for(Object val:row) {
						System.out.print(val+"  ");
					}//for
					System.out.println();
				}); //for each
			}//try
			catch (HibernateException he) {
				he.printStackTrace();
			}//catch			
		}//method

		// Solution (2) -> Using JPQBC Concept to avoid 1+N Query generation problem
		@Override
		public void loadDataUsingJPQBC() {
			Session ses = HibernateUtil.getSession();
			try(ses){
				//create CriteriaBuilder Object
				CriteriaBuilder cBuilder = ses.getCriteriaBuilder();
				//create CriteriaQuery Object
				CriteriaQuery<Department> ctQuery = cBuilder.createQuery(Department.class);
				//create Root object specifying the from Operation
				Root<Department> root = ctQuery.from(Department.class); 	//Performs Select * from Department
				root.fetch("employees",JoinType.INNER);
				//create Query object having CriteriaQuery Object
				Query query = ses.createQuery(ctQuery);
				//execute the QBC logic
				List<Department> list = query.getResultList();
				//process the result
				list.forEach(dept->{
					System.out.println("Parent :: "+dept);
					//get child objects
					Set<Employee> child = dept.getEmployees();
					child.forEach(emp->{
						System.out.println("Child :: "+emp);
					});
					System.out.println();
				});
			}//try
			catch (HibernateException he) {
				he.printStackTrace();
			}//catch			
		}//method

		

		
}//class
