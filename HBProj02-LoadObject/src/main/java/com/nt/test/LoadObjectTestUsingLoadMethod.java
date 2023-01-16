//LoadObjectTestUsingLoadMethod.java (main/client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class LoadObjectTestUsingLoadMethod {
    public static void main( String[] args )  {
        //BootStrap or Activate the Hibernate
    		Configuration cfg = new Configuration();
    	//specify the hibernate cfgs file name and location
    		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
    	//build SessionFactory obj with all the services  specified in the cfgs file and mapping file
    		SessionFactory factory = cfg.buildSessionFactory();
		//create Session object
    		Session ses = factory.openSession();
  
    		//try with resource java 9 syntax
    		try (factory;ses){
    				//Load Object using getMethod()
    					Product prod = ses.load(Product.class, 1001);
    					System.out.println(prod.getClass()+"         "+prod.getClass().getSuperclass());
    					System.out.println("=========================================================================");
    				    System.out.println(prod);				
    		}//try
    		catch (HibernateException hi) {
    			System.out.println("Product not found");
    			hi.printStackTrace();
    		}//catch
    		
    }//main
}//class
