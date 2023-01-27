//NativeSelectTest.java
package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil;

public class NativeSelectTest {
    public static void main( String[] args ) {
        //get the SessionFactory and Session Object
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session ses = HibernateUtil.getSession();
    	Transaction tx = null;
    	try(factory;ses){
    		NativeQuery query = ses.createNativeQuery("select * from Product");
    		query.addEntity(Product.class);
    		List<Product> list = query.getResultList();
    		list.forEach(System.out::println);
    	}//try
    	catch (HibernateException he) {
    		he.printStackTrace();
    		System.out.println("Problem in executing the Query");
		}//catch
    }//main
}//class
