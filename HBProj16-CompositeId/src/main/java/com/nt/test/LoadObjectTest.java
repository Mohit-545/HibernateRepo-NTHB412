//LoadObjectTest.java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utils.HibernateUtil;

public class LoadObjectTest {
    public static void main( String[] args ){
    	//get the Session object
    	Session ses = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = null;
    	try(ses){
    		tx = ses.beginTransaction();
    		//prepare id class object
    		PrgmrProjId id = new PrgmrProjId(101, 1001);
    		//load object
    		ProgrammerProjectInfo info = ses.get(ProgrammerProjectInfo.class, id);
    		if(info==null) {
    			System.out.println("Object not found");
    			return;
    		}//if
    		else {
	    		System.out.println(info);
	    		tx.commit();
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
