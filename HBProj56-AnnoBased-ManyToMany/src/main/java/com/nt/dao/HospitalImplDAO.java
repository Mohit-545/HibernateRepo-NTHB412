//HospitalImplDAO.java
package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.print.Doc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Doctor;

import com.nt.entity.Patient;
import com.nt.utils.HibernateUtil;

public class HospitalImplDAO implements IHospitalDAO {

	@Override
	public void saveDataUsingParent() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			//create Parent Objects
			Doctor doc1 = new Doctor();
			doc1.setDocName("Aniket Shah"); doc1.setHospital("Apollo");
			Doctor doc2 = new Doctor();
			doc2.setDocName("Satyam Kumar"); doc2.setHospital("Aditya Birla");
			//create child objects
			Patient pat1 = new Patient();
			pat1.setPatName("Akhil");  pat1.setProblem("Cancer");
			Patient pat2 = new Patient();
			pat2.setPatName("Mukesh"); pat2.setProblem("Fracture");
			Patient pat3 = new Patient();
			pat3.setPatName("Ramesh"); pat3.setProblem("Food Poisioning");
			//assigning childs to parents
			doc1.setPatients(Set.of(pat1, pat2,pat3));
			doc2.setPatients(Set.of(pat1, pat2));
			//assign parents to childs
			pat1.setDoctors(Set.of(doc1,doc2));
			pat2.setDoctors(Set.of(doc1,doc2));
			pat3.setDoctors(Set.of(doc1));
			//begin tx
			tx = ses.beginTransaction();
			//save through parent object
			ses.save(doc1);  ses.save(doc2);
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
			//create Parent Objects
			Doctor doc1 = new Doctor();
			doc1.setDocName("Ashish Nehra"); doc1.setHospital("Ruby Hall");
			Doctor doc2 = new Doctor();
			doc2.setDocName("Suresh Yadav"); doc2.setHospital("Jehangir");
			//create child objects
			Patient pat1 = new Patient();
			pat1.setPatName("Manoj");  pat1.setProblem("HeadAche");
			Patient pat2 = new Patient();
			pat2.setPatName("Rohit"); pat2.setProblem("Eye Problem");
			Patient pat3 = new Patient();
			pat3.setPatName("Tarun"); pat3.setProblem("Fistula");
			//assigning childs to parents
			doc1.setPatients(Set.of(pat1, pat2,pat3));
			doc2.setPatients(Set.of(pat1, pat2));
			//assign parents to childs
			pat1.setDoctors(Set.of(doc1,doc2));
			pat2.setDoctors(Set.of(doc1,doc2));
			pat3.setDoctors(Set.of(doc1));
			//begin tx
			tx = ses.beginTransaction();
			//save through childs object
			ses.save(pat1);  ses.save(pat2); ses.save(pat3);
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
			Query query = ses.createQuery("from Doctor");
			List<Doctor> list = query.getResultList();
			list.forEach(doc->{
				System.out.println("Parent :: "+doc);
				Set<Patient> child = doc.getPatients();
				child.forEach(pat->{
					System.out.println("Child :: "+pat);
				});
			});
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in saving Objects");
			}
		}//catch
	}//method
		
}//class
