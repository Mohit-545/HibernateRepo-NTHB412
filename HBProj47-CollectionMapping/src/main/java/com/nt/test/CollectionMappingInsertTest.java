//CollectionMappingInsertTest.java (client class)
package com.nt.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.nt.entity.PersonDetails;
import com.nt.utils.HibernateUtil;

public class CollectionMappingInsertTest {
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    		Transaction tx = null;
    	try(factory;ses){
    		//create or prepare objects
    		PersonDetails pdetails = new PersonDetails();
    			pdetails.setPname("Suraj Chandra");
    			pdetails.setPaddrs("Chennai");
    			pdetails.setNickNames(List.of("surya", "golu"));
    			pdetails.setFriends(List.of("Raju", "Lala"));
    			pdetails.setContactNumbers(Set.of(8955989798L, 9998885985L));
    			pdetails.setIdDetails(Map.of("Aadhar Card", 9856745874782567L, "Pan Card", 95874199L));
 
    		//begin tx
    			tx = ses.beginTransaction();
    		//save objects
    			ses.save(pdetails);
    		//commit TX
    			tx.commit();
    	}//try
    	catch (HibernateException he) {
    		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
    			tx.rollback();
    			System.out.println("Object is not saved or updated");
			he.printStackTrace();
		}//catch
    }//main
}//class
