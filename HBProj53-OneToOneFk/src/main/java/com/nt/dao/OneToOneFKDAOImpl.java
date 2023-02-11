//OneToOneFKDAOImpl.java
package com.nt.dao;

import java.time.LocalDate;
import java.util.List;


import javax.persistence.Query;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



import com.nt.entity.Passport;
import com.nt.entity.Person;

import com.nt.utils.HibernateUtil;

public class OneToOneFKDAOImpl implements IOneToOneFKDAO {

	@Override
	public void saveDataUsingChild() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			//create Parent Object
			Person per = new Person();
			per.setPname("Akash"); per.setPaddrs("Kolkata"); 
			//create child object
			Passport pspt = new Passport();
			pspt.setCountry("India"); pspt.setExpiryDate(LocalDate.of(2035, 05, 15));
			//assinging parent to child  
			pspt.setPersonDetails(per);
			//begin tx
			tx = ses.beginTransaction();
			//save through child object
			ses.save(pspt); 
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
	public void loadDataUsingChild() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			Query query = ses.createQuery("from Student");
			List<Passport> list = query.getResultList();
			list.forEach(pspt->{
				System.out.println("Child :: "+pspt);
				Person per = pspt.getPersonDetails();
					System.out.println("Parent :: "+per);
			});
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
		}//catch
	}//method
		
}//class
