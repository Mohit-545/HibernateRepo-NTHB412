//HQLNonSelectDeleteTest.java
package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil;

public class HQLNonSelectDeleteTest {
    public static void main( String[] args ) {
        //get the SessionFactory and Session Object
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session ses = HibernateUtil.getSession();
    	Transaction tx = null;
    	try(factory;ses){
    		//begin Tx
    		tx = ses.beginTransaction();
    		// prepare HQL Non Select Query (for updating records) 
				Query query = ses.createQuery("delete from Product where qty<=:val");
				query.setParameter("val", 10.0f);
    		//execute the HQL Query
    		int count = query.executeUpdate();
    		tx.commit();
    		//process the result 
    			System.out.println("No of records affected :: "+count);
    	}//try
    	catch (HibernateException he) {
    		if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
    			tx.rollback();
    			System.out.println("Problem in executing the Query");
    		}
			he.printStackTrace();
		}//catch
    }//main
}//class
