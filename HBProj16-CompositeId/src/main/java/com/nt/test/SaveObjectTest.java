//SaveObjectTest.java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utils.HibernateUtil;

public class SaveObjectTest {
    public static void main( String[] args ){
    	//get the Session object
    	Session ses = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = null;
    	try(ses){
    		//begin Tx
    		tx = ses.beginTransaction();
    		//prepare id class object
    		PrgmrProjId id = new PrgmrProjId(103, 1001);
    		//create entity class object
    		ProgrammerProjectInfo pInfo = new ProgrammerProjectInfo(id, "Raja", "OpenFx", 72000.0, 3000000.0);
    		//save the object
    		PrgmrProjId idVal = (PrgmrProjId)ses.save(pInfo);
    		//commit the Tx
    		tx.commit();
    		System.out.println("Record/Object is saved with id value :: "+idVal);
    		
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
