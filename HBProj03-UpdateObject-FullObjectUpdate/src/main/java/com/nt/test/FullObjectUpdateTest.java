//FullObjectUpdateTest.java (main/client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class FullObjectUpdateTest {
    public static void main( String[] args )  {
        //BootStrap or Activate the Hibernate
    		Configuration cfg = new Configuration();
    	//specify the hibernate cfgs file name and location
    		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
    	//build SessionFactory obj with all the services  specified in the cfgs file and mapping file
    		SessionFactory factory = cfg.buildSessionFactory();
		//create Session object
    		Session ses = factory.openSession();
    		Transaction tx = null;
    		//try with resource java 9 syntax
    		try (factory;ses){
    			// begin transaction
    			tx = ses.beginTransaction();
    				//Modify the object data fully
    					Product prod = new Product();
    					prod.setPid(1007); //id should be pre-exsisting
    					prod.setPname("Wash Basin");  // new value
    					prod.setPrice(12000.0f);  // new value
    					prod.setQty(25.0f);  // new value
    				//instruction to update the Object
    					ses.update(prod);
    				//commit the transaction
    					tx.commit();
    					System.out.println("Full Object is Updated");
    					
    		}//try
    		catch (HibernateException hi) {
    			hi.printStackTrace();
    			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
    				tx.rollback();
    			System.out.println("Product not found");
    			}
    		}//catch
    		catch (Exception e) {
				e.printStackTrace();
			}//catch
    		
    }//main
}//class
