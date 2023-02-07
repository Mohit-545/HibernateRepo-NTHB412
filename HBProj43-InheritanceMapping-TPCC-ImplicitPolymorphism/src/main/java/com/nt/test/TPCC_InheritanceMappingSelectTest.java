//TPCH_InheritanceMappingSelectTest.java (client class)
package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utils.HibernateUtil;

public class TPCC_InheritanceMappingSelectTest{
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    	try(factory;ses){
    		Query query1 = ses.createQuery("from Person");
    		List<Person> list1 = query1.getResultList();
    		list1.forEach(System.out::println);
    		System.out.println("==============================================================");

    		Query query2 = ses.createQuery("from Employee");
    		List<Employee> list2 = query2.getResultList();
    		list2.forEach(System.out::println);
    		System.out.println("===============================================================");
    		
    		Query query3 = ses.createQuery("from Customer");
    		List<Customer> list3 = query3.getResultList();
    		list3.forEach(System.out::println);
    		System.out.println("================================================================");
    		
    	}//try
    	catch (HibernateException he) {
			he.printStackTrace();
		}//catch
    }//main
}//class
