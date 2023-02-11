//OneToOnePKDAOImpl.java
package com.nt.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.print.Doc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.nt.entity.LibraryMembership;

import com.nt.entity.Student;
import com.nt.utils.HibernateUtil;

public class OneToOnePKDAOImpl implements IOneToOnePKDAO {

	@Override
	public void saveDataUsingParent() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			//create Parent Object
			Student st = new Student();
			st.setSname("Raja");	st.setSaddrs("Chennai"); 
			//create child object
			LibraryMembership lb = new LibraryMembership();
			lb.setType("Gold"); lb.setDoj(LocalDate.now());
			//assigning childs to parents and vice-versa
			lb.setStudentDetails(st);   st.setLibraryDetails(lb);
			//begin tx
			tx = ses.beginTransaction();
			//save through parent object
			ses.save(st); 
			//commit the tx
			tx.commit();
			System.out.println("Objects are saved");
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in saving Objects");
			}
		}//catch
		
	}//method

	@Override
	public void saveDataUsingChild() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			//create Parent Object
			Student st = new Student();
			st.setSname("Paresh");	st.setSaddrs("Mumbai"); 
			//create child object
			LibraryMembership lb = new LibraryMembership();
			lb.setType("Silver"); lb.setDoj(LocalDate.now());
			//assinging childs to parents and vice-versa
			lb.setStudentDetails(st);   st.setLibraryDetails(lb);
			//begin tx
			tx = ses.beginTransaction();
			//save through parent object
			ses.save(lb); 
			//commit the tx
			tx.commit();
			System.out.println("Objects are saved");
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in saving Objects");
			}
		}//catch
		
	}//method

	@Override
	public void loadDataUsingParent() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			Query query = ses.createQuery("from Student");
			List<Student> list = query.getResultList();
			list.forEach(stud->{
				System.out.println("Parent :: "+stud);
				LibraryMembership lib = stud.getLibraryDetails();
					System.out.println("Child :: "+lib);
			});
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
		}//catch
	}//method
		
}//class
