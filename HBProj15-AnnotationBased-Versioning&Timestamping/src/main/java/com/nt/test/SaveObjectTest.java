//SaveObjectTest.java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.utils.HibernateUtil;

public class SaveObjectTest {
    public static void main( String[] args ){
    	//get the Session object
    	Session ses = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = null;
    	try(ses){
    		tx = ses.beginTransaction();
    		CallerTune tune = new CallerTune();
    		tune.setTuneName("srivalli"); tune.setMovieName("Pushpa - The Rise");
    		ses.save(tune);
    		tx.commit();
    		System.out.println("Object is saved");
    		System.out.println(tune);
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
