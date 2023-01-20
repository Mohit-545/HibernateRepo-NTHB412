//UpdateObjectTest.java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Stock;
import com.nt.utils.HibernateUtil;

public class UpdateObjectTest {
    public static void main( String[] args ){
    	//get the Session object
    	Session ses = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = null;
    	try(ses){
    		tx = ses.beginTransaction();
    		//get the object
    		Stock stk = ses.get(Stock.class, 1);
    		if(stk==null) {
    			System.out.println("Object not found");
    			return;
    		}//if
    		else {
	    		stk.setPrice(800.50);
	    		ses.update(stk);
	    		tx.commit();
	    		System.out.println("Object is update");
	    		System.out.println("Record/Object is last updated at - "+stk.getLastUpdated());
	    		System.out.println(stk);
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
