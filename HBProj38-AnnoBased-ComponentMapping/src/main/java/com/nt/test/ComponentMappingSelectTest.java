//ComponentMappingSelectTest.java (client class)
package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utils.HibernateUtil;

public class ComponentMappingSelectTest {
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    		Transaction tx = null;
    	try(factory;ses){
			//create and execute HQL/JPQL query
			Query query1 = ses.createQuery("from Person");
			//execute the query
			List<Person> list1 = query1.getResultList();
			System.out.println();
			//process the results
			list1.forEach(per->{
				System.out.println("Person Details := "+per.getPid()+"   "+per.getPname()+"   "+per.getAddrs());
				JobDetails details = per.getDetails();
				System.out.println("Job Detalis := "+details.getCompany()+"   "+details.getDesg()+"   "+details.getSalary());
				System.out.println();
			});
			System.out.println();
    		
    		// involving the sub property of main property in Select HQL Query condition
    		Query query2 = ses.createQuery("from Person where details.company=?1");
    		//set values to query params
    		query2.setParameter(1,"TCS");
    		//execute the query
    		List<Person> list2 = query2.getResultList();
    		System.out.println();
    		//process the result
    		list2.forEach(per->{
    			System.out.println("Person Details := "+per.getPid()+"   "+per.getPname()+"   "+per.getAddrs());
    			JobDetails details = per.getDetails();
    			System.out.println("Job Detalis := "+details.getCompany()+"   "+details.getDesg()+"   "+details.getSalary());
    			System.out.println();
    		});
    	}//try with resources
    	catch (HibernateException he) {
			he.printStackTrace();
		}//catch
    }//main
}//class
