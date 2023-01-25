//NamedHQLTest.java
package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil;

public class AnnoBasedNamedHQLTest {
    public static void main( String[] args ) {
        //get the SessionFactory and Session Object
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session ses = HibernateUtil.getSession();
    	Transaction tx = null;
    	try(factory;ses){
    		Query query = ses.getNamedQuery("HQL_GET_PRODUCTS_BY_PRICE_RANGE");
    		query.setParameter("min", 6000.0f);
    		query.setParameter("max", 76000.0f);
    		List<Product> list = query.getResultList();
    		//process the result
    		list.forEach(System.out::println);
    		
    		//begin Tx
    		tx = ses.beginTransaction();
    		// prepare HQL Non Select Query (for updating records) 
				Query query1 = ses.getNamedQuery("INCREASE_PRODUCT_PRICE_BY_PRICE_RANGE");
				query1.setParameter("newValue", 500.0f);
				query1.setParameter("priceRange", 20000.0f);
    		//execute the HQL Query
    		int count = query1.executeUpdate();
    		tx.commit();
    		//process the result 
    			System.out.println("No of records affected :: "+count);
    	}//try
    	catch (HibernateException he) {
    		if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
    			tx.rollback();
    			System.out.println("Problem in executing the Query");
    		}
			he.printStackTrace();
		}//catch
    }//main
}//class
