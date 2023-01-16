//LoadObjectTestUsingGetMethod.java (client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil;

public class LoadObjectTestUsingGetMethod {
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    	try(factory;ses){
    		// load object
    			Product prod = ses.get(Product.class, 1001);
    			if(prod==null)
    				System.out.println("Record not found");
    			else
    			System.out.println(prod);
    	}//try with resources
    	catch (HibernateException he) {
			he.printStackTrace();
		}//catch
    }//main
}//class
