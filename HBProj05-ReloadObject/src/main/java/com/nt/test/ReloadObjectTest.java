//ReloadObjectTest.java (client/main class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class ReloadObjectTest {
    public static void main( String[] args ) {
    	//get the configuration object
    		Configuration cfg = new Configuration();
    	// configure the hibernate cfg file
    		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
    	// build session factory object
    		SessionFactory factory = cfg.buildSessionFactory();
    	// get Session object
    		Session ses = factory.openSession();
    	//try with resource (java 9 syntax)
    		try(factory;ses){
    			// load the Product object
    				Product prod = ses.get(Product.class, 1001);
    				if(prod==null) {
    					System.out.println("Record not found");
    					return;
    				}//if
    				else {
    					//display the record
    					System.out.println("Record before data updation :: "+prod);
    					//now the make the app Sleep for 30ms
    					System.out.println("Now the App is going to Sleep for 30 milli-secs ");
    					Thread.sleep(30000);
    					// modify the row data and refresh the app
    					ses.refresh(prod);  // this reloads the data from DB by running pre-generated Select sql query
    					System.out.println("Record after data updation :: "+prod);
    				}//else
    		}//try
    		catch (HibernateException hi) {
    			hi.printStackTrace();
			}//catch
    		catch (Exception e) {
				e.printStackTrace();
			}//catch

    }//main
}//class
