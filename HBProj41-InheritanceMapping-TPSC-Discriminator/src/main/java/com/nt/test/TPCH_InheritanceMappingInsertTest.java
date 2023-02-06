//TPCH_InheritanceMappingInsertTest.java (client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utils.HibernateUtil;

public class TPCH_InheritanceMappingInsertTest {
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    		Transaction tx = null;
    	try(factory;ses){
    		//create or prepare objects
    		Person person = new Person();
    		person.setPname("Mukesh"); person.setCompany("TCS");
    		
    		Employee emp = new Employee("Developer", 97000.0, 1002);
    		emp.setPname("Raghav"); emp.setCompany("KPMG");
    		
    		Customer cust = new Customer(2658, 22795.0);
    		cust.setPname("Kalpesh"); cust.setCompany("NOKIA");
    		//begin tx
    			tx = ses.beginTransaction();
    		//save objects
    			ses.save(person);
    			ses.save(cust);
    			ses.save(emp);
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
