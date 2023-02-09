//CompanyImplDAO.java
package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.entity.IDepartment;
import com.nt.utils.HibernateUtil;

public class CompanyImplDAO implements ICompanyDAO {

	@Override
	public void saveDataUsingParent() {
		/*Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			//begin tx
			tx = ses.beginTransaction();
			//create Parent Object
			Department dept = new Department();
			dept.setDeptName("IT"); dept.setDeptHead("James");
			
			//create child objects
			Employee emp1 = new Employee();
			emp1.setEmpName("Rahul"); emp1.setEmpSalary(83568.0);
			
			Employee emp2 = new Employee();
			emp2.setEmpName("Lokesh"); emp2.setEmpSalary(92458.0);
			
			//set child objs to parent class obj (for one to many)
			dept.setEmployees(Set.of(emp1, emp2));
			
			//set parent objs to child (for many to one)
			emp1.setDept(dept);		emp2.setDept(dept);
			
			//save through parent object
			ses.save(dept);
			//commit the tx
			tx.commit();
			System.out.println("Parents to child are saved");
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Parents to child are not saved");
			}
		}//catch
		*/
	}//method

	@Override
	public void saveDataUsingChild() {
		/*Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			//begin tx
			tx = ses.beginTransaction();
			//create Parent Object
			Department dept = new Department();
			dept.setDeptName("Engineering"); dept.setDeptHead("Mahesh");
			
			//create child objects
			Employee emp1 = new Employee();
			emp1.setEmpName("Rakesh"); emp1.setEmpSalary(88868.0);
			
			Employee emp2 = new Employee();
			emp2.setEmpName("Mahima"); emp2.setEmpSalary(96988.0);
			
			//set child objs to parent class obj (for one to many)
			dept.setEmployees(Set.of(emp1, emp2));
			
			//set parent objs to child (for many to one)
			emp1.setDept(dept);		emp2.setDept(dept);
			
			//save through child object
			ses.save(emp1); ses.save(emp2);
			//commit the tx
			tx.commit();
			System.out.println("Child to Parent are saved");
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Child to Parent are not saved");
			}
		}//catch
		*/
	}//method

	@Override
	public void loadDataUsingParent() {
		/*Session ses = HibernateUtil.getSession();
		try(ses){
			//load parent and associated child objects
			Query query = ses.createQuery("from Department");
			List<Department> list = query.getResultList();
			list.forEach(dept->{
				System.out.println(dept);
				Set<Employee> child = dept.getEmployees();
				child.forEach(emp->{
					System.out.println(emp);
				});
				System.out.println();
			});
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
		}//catch*/
		
		}//method
		
		@Override
		public void loadDataUsingChild() {
		/*Session ses = HibernateUtil.getSession();
		try(ses){
			//load parent and associated child objects
			Query query = ses.createQuery("from Employee");
			List<Employee> list = query.getResultList();
			list.forEach(emp->{
				System.out.println("Child :: "+emp);
				Department dept = emp.getDept();
				System.out.println("Parent :: "+dept);
			});
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
		}//catch
		
		*/	}//method

	@Override
	public void loadDataUsingChildWithProxy() {
		Session ses = HibernateUtil.getSession();
		try(ses){
			//load parent and associated child objects
			Query query = ses.createQuery("from Employee");
			List<Employee> list = query.getResultList();
			list.forEach(emp->{
				System.out.println("Child :: "+emp);
				IDepartment dept = emp.getDept();
				System.out.println("Parent :: "+dept);
			});
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
		}//catch
	}//method
		
}//class
