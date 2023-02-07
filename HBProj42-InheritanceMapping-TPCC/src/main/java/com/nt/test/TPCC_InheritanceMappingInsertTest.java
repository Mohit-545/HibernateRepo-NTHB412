//TPCC_InheritanceMappingInsertTest.java (client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utils.HibernateUtil;

public class TPCC_InheritanceMappingInsertTest {
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
    		person.setPname("Mahesh"); person.setCompany("HCL");
    		
    		Employee emp = new Employee("Tester", 58000.0, 1001);
    		emp.setPname("Mehul"); emp.setCompany("WIPRO");
    		
    		Customer cust = new Customer(2458, 19856.0);
    		cust.setPname("Rakesh"); cust.setCompany("SAMSUNG");
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
