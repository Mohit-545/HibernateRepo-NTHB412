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
    		//(1) prepare the Query object having HQL/JPQL Query with JPA Style Positional paramteres
						//Query query = ses.createQuery("from Product where pid>=?0 and pid<=?1");
						//query.setParameter(0, 1001);
						//query.setParameter(1, 1005);
    		//(2) prepare the Query object having HQL/JPQL Query with JPA Style Named paramteres
		    		Query query = ses.createQuery("from Product where pname in(:prod1,:prod2,:prod3) order by pname asc");
		    		query.setParameter("prod1", "WASH BASIN");
		    		query.setParameter("prod2", "TV");
		    		query.setParameter("prod3", "Mirror");
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
