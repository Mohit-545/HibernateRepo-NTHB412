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
import com.nt.utils.HibernateUtil;

public class CompanyImplDAO implements ICompanyDAO {

		@Override
		public void loadDataUsingJoinsParentToChild() {
			Session ses = HibernateUtil.getSession();
			try(ses){
				Query query = ses.createQuery(//"select d.deptNo,d.deptName,d.deptHead,e.empNo,e.empName,e.empSalary from Department d inner join d.employees e"
																			//"select d.deptNo,d.deptName,d.deptHead,e.empNo,e.empName,e.empSalary from Department d left join d.employees e"
																			//"select d.deptNo,d.deptName,d.deptHead,e.empNo,e.empName,e.empSalary from Department d right join d.employees e"
																			"select d.deptNo,d.deptName,d.deptHead,e.empNo,e.empName,e.empSalary from Department d full join d.employees e"
																			);
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

		@Override
		public void loadDataUsingJoinsChildToParent() {
			Session ses = HibernateUtil.getSession();
			try(ses){
				//load parent and associated child objects
				Query query = ses.createQuery(//"select e.empNo,e.empName,e.empSalary,d.deptNo,d.deptName,d.deptHead from Employee e inner join e.dept d"
																			//"select e.empNo,e.empName,e.empSalary,d.deptNo,d.deptName,d.deptHead from Employee e left join e.dept d"
																			//"select e.empNo,e.empName,e.empSalary,d.deptNo,d.deptName,d.deptHead from Employee e right join e.dept d"
																			"select e.empNo,e.empName,e.empSalary,d.deptNo,d.deptName,d.deptHead from Employee e full join e.dept d"
																			);
				List<Object[]> list = query.getResultList();
				list.forEach(row->{
					for(Object val:row) {
						System.out.print(val+"   ");
					}//for
					System.out.println();
				}); //for each
			}//try
			catch (HibernateException he) {
				he.printStackTrace();
			}//catch			
		}//method

		
}//class
