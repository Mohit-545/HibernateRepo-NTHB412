//SaveObjectTest.java (main/client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {
    public static void main( String[] args )  {
        //BootStrap or Activate the Hibernate
    		Configuration cfg = new Configuration();
    	//specify the hibernate cfgs file name and location
    		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
    		Transaction tx = null;  
    		try (//build SessionFactory obj with all the services  specified in the cfgs file and mapping file
    	    		SessionFactory factory = cfg.buildSessionFactory();
    				//create Session object
    	    		Session ses = factory.openSession();){
    			//begin Transaction
    				tx = ses.beginTransaction();  //this internal calls setAutoCommit(false) to disable auto commit on DB s/w
    				
    				//prepare entity class object
    					Product p = new Product();
    				p.setPname("FAN"); p.setPrice(1800.0f); p.setQty(20.0f);
    				//save the object
    					Integer idVal = (Integer) ses.save(p);
    					System.out.println("The generated IdVal is :: "+idVal);
    				//commit the transaction
    					tx.commit();  //this internally calls con.commit() method
    					System.out.println("Object is saved and Record is Inserted");
    		}//try
    		catch (HibernateException hi) {
    			hi.printStackTrace();
    			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
		    			tx.rollback();  //this internally calls con.rollback() method
		    			System.out.println("Object is not saved and Record is not inserted");

    			}//if
			}//catch
    		
    }//main
}//class
