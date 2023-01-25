//PaginationTest.java
package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil;

public class PaginationTest {
    public static void main( String[] args ) {
        //get the SessionFactory and Session Object
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session ses = HibernateUtil.getSession();
    	Transaction tx = null;
    	try(factory;ses){
    		Query query = ses.createQuery("from Product");
    		query.setFirstResult(0);		//start position       (change value to 3,6,9..)
    		query.setMaxResults(3);	//page size 
    		List<Product> list = query.getResultList();
    		//process the result
    		list.forEach(System.out::println);
    	}//try
    	catch (HibernateException he) {
    		he.printStackTrace();
   			System.out.println("Problem in executing the Query");
		}//catch
    }//main
}//class
