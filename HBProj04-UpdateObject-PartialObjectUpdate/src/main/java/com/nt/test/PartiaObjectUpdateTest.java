//PartialObjectUpdateTest.java (main/client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class PartiaObjectUpdateTest {
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
    			// get the Object to check if data is available or not 
    				Product prod = ses.get(Product.class, 1001);
    				if(prod==null) {
    					System.out.println("Record not found");
    					return;
    				}//if
    				else {
    					// begin transaction
    						tx = ses.beginTransaction();
    					//modify the object partially
    						prod.setQty(10.0f);
    					//instruction to update the Object
    					//	ses.update(prod); (optional becoz full object is loaded before doing any updation in the loaded object and commit)
    					//commit the transaction
	    					tx.commit();
	    					System.out.println("Object is Updated Partially");
    				}//else
    		}//try
    		catch (HibernateException hi) {
    			hi.printStackTrace();
    			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
    				tx.rollback();
    			System.out.println("Object is not Update");
    			}
    		}//catch
    		catch (Exception e) {
				e.printStackTrace();
			}//catch
    		
    }//main
}//class
