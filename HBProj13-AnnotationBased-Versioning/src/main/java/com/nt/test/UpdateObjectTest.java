//UpdateObjectTest.java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.utils.HibernateUtil;

public class UpdateObjectTest {
    public static void main( String[] args ){
    	//get the Session object
    	Session ses = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = null;
    	try(ses){
    		tx = ses.beginTransaction();
    		//get the object
    		CallerTune tune = ses.get(CallerTune.class, 1);
    		if(tune==null) {
    			System.out.println("Object not found");
    			return;
    		}//if
    		else {
	    		tune.setTuneName("sami sami");
	    		ses.update(tune);
	    		tx.commit();
	    		System.out.println("Object is update");
	    		System.out.println("Object is updated for - "+tune.getUpdationCount()+" times");
	    		System.out.println(tune);
    		}//else
    	}//try
    	catch (HibernateException he) {
    		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
    			tx.rollback();
    			System.out.println("Object is not saved");
    		}//if
			he.printStackTrace();
		}//catch
  
    }//main
}//class
