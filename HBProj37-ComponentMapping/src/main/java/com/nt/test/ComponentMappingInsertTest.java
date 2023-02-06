//ComponentMappingInsertTest.java (client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utils.HibernateUtil;

public class ComponentMappingInsertTest {
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    		Transaction tx = null;
    	try(factory;ses){
    		//begin tx
    			tx = ses.beginTransaction();
    			//create dependent class obj
    			JobDetails details = new JobDetails();
    			details.setCompany("INFOSYS"); details.setDesg("SpringBoot Developer"); details.setSalary(135000.0f);
    			//create target class obj
    			Person person = new Person();
    			person.setPname("Raja Mudri"); person.setAddrs("Hyd"); person.setDetails(details);
    			// save the object
    			int idVal = (Integer)ses.save(person);
    			System.out.println("Person is saved with Id Value -> "+idVal);
    			//commit TX
    			tx.commit();
    	}//try with resources
    	catch (HibernateException he) {
    		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
    			tx.rollback();
    			System.out.println("Object is not saved or updated");
			he.printStackTrace();
		}//catch
    }//main
}//class
