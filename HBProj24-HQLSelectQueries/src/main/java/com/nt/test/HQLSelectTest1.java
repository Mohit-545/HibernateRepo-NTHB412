//HQLSelectTest.java
package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil;

public class HQLSelectTest1 {
    public static void main( String[] args ) {
        //get the SessionFactory and Session Object
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session ses = HibernateUtil.getSession();
    	try(factory;ses){
    		//prepare the Query object having HQL/JPQL Query
    		Query query = ses.createQuery("from Product");
    		//execute the HQL Query
    		List<Product> list = query.list();
    		//process the result ( can use lambda exp or method reference)
    		list.forEach(p -> {System.out.println(p);});	//lambda exp used to iterate and process the result
    		//list.forEach(System.out::println); 		//Method Reference used to process the result
    	}//try
    	catch (Exception e) {
			e.printStackTrace();
		}//catch
    }//main
}//class
