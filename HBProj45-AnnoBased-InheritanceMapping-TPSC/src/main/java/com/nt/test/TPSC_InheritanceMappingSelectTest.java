//TPSC_InheritanceMappingSelectTest.java (client class)
package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.entity.Payment;
import com.nt.utils.HibernateUtil;

public class TPSC_InheritanceMappingSelectTest {
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    		Transaction tx = null;
    	try(factory;ses){
			//create and execute HQL/JPQL query
			Query query1 = ses.createQuery("from CardPayment");
			//execute the query
			List<CardPayment> list1 = query1.getResultList();
			System.out.println();
			//process the results
			list1.forEach(System.out::println);
			System.out.println("==================================================");
    		
			//create and execute HQL/JPQL query
			Query query2 = ses.createQuery("from ChequePayment");
			//execute the query
			List<ChequePayment> list2 = query2.getResultList();
			System.out.println();
			//process the results
			list2.forEach(System.out::println);
			System.out.println("==================================================");
    		
			//create and execute HQL/JPQL query
			Query query3 = ses.createQuery("from Payment");
			//execute the query
			List<Payment> list3 = query3.getResultList();
			System.out.println();
			//process the results
			list3.forEach(System.out::println);
			System.out.println("==================================================");
 	
    	}//try with resources
    	catch (HibernateException he) {
			he.printStackTrace();
		}//catch
    }//main
}//class
