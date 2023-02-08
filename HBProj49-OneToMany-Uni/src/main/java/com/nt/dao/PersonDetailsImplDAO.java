//PersonDetailsImplDAO.java
package com.nt.dao;


import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.PersonDetails;
import com.nt.entity.PhoneNumber;
import com.nt.utils.HibernateUtil;

public class PersonDetailsImplDAO implements IPersonDetailsDAO {

	@Override
	public void saveDataUsingParent() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(factory;ses){
			//begin tx
			tx = ses.beginTransaction();
			//create Person Object
			PersonDetails pdetails = new PersonDetails();
			pdetails.setPname("Sunil"); pdetails.setPaddrs("Hyd"); 
			
			//create child objects
			PhoneNumber ph1 = new PhoneNumber();
			ph1.setMobileNo(9856874985L); ph1.setNumberType("Home"); ph1.setProvider("Bsnl");
			
			PhoneNumber ph2 = new PhoneNumber();
			ph2.setMobileNo(6857859876L); ph2.setNumberType("Work"); ph2.setProvider("Idea");
			
			//set child obj to parent class obj
			pdetails.setPhones(Set.of(ph1, ph2));
			//save the parent object
			Integer idVal = (Integer)ses.save(pdetails);
			//process the result
			System.out.println("Generated Id Values are :: "+idVal);
			//commit the tx
			tx.commit();
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Parent and associated child are not saved");
			}
		}//catch

	}//method

	@Override
	public void loadDataUsingParent() {
		Session ses = HibernateUtil.getSession();
		try(ses){
			Query query = ses.createQuery("from PersonDetails");
			List<PersonDetails> list = query.getResultList();
			list.forEach(pd->{
				System.out.println("Parent :: "+pd);
				//get the child obj
				Set<PhoneNumber> childs = pd.getPhones();
				childs.forEach(pn->{
					System.out.println("Childs :: "+pn);
				});
				System.out.println();
			});
			
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}//method

	@Override
	public void addChildToExistingParent() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			//begin tx 
			tx = ses.beginTransaction();
			//load existing Parent object
			PersonDetails pd = ses.get(PersonDetails.class, 1);
			//get all child obj from existing parent obj
			Set<PhoneNumber> child = pd.getPhones();
			//create new child object
			PhoneNumber pn = new PhoneNumber();
			pn.setMobileNo(8877125955L);  pn.setNumberType("Business");  pn.setProvider("Vodafone");
			//add new child to existing parent
			child.add(pn);
			//commit tx 
			tx.commit();
			System.out.println("Child is added to existing childs of Parent");
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null||tx.getRollbackOnly()||tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("Child is not added to existing Childs of Parent");
			}
		}//catch
		
	}//method

	@Override
	public void deleteAllChildsOfAParent() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			tx = ses.beginTransaction();
			//load existing parent
			PersonDetails pd = ses.get(PersonDetails.class, 1);
			//get all childs of existing parent
			Set<PhoneNumber> childs = pd.getPhones();
			//delete all childs 
			childs.removeAll(childs);
			tx.commit();
			System.out.println("All Childs of Parent are removed");
			
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null||tx.getRollbackOnly()||tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("Child is not added to existing Childs of Parent");
			}
		}//catch
		
	}//method

	@Override
	public void deleteOneChildFromCollectionOfChildsOfAParent() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			tx = ses.beginTransaction();
			//load the parent class obj
			PersonDetails pd = ses.get(PersonDetails.class, 1);
			//load all childs of the parent 
			Set<PhoneNumber> child = pd.getPhones();
			//load specific child of existing parent that we want to delete
			PhoneNumber ph = ses.get(PhoneNumber.class, 1008);
			child.remove(ph);
			tx.commit();
			System.out.println("Specific child of a Parent is deleted");
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null||tx.getRollbackOnly()||tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("Child is not added to existing Childs of Parent");
			}
		}//catch
		
	}//mehtod

	@Override
	public void deleteParentAndItsChilds() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			tx = ses.beginTransaction();
			//load a parent which leads to loading of its all childs obj
			PersonDetails details = ses.get(PersonDetails.class, 2);
			//delete Parent which will delete its child also
			ses.delete(details);
			tx.commit();
			System.out.println("Parent and its associated childs are deleted");
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null||tx.getRollbackOnly()||tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("Child is not added to existing Childs of Parent");
			}
		}//catch
		
	}//method

}//class
