//MergeObjectTestApproach1.java (client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil;

public class MergeObjectTestApproach1 {
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    		Transaction tx = null;
    	try(factory;ses){
    		//begin tx
    			tx = ses.beginTransaction();
    			Product prod = new Product();
    			prod.setPid(1001);
    			prod.setPname("Table");
    			prod.setPrice(8900f);
    			prod.setQty(18f);
    			//merge the object
    			Product prod1 = (Product)ses.merge(prod);
    			tx.commit();
    			System.out.println("Given object data:: "+prod+" hashcode:: "+prod.hashCode());
    			System.out.println("Recieved object data:: "+prod1+" hashcode:: "+prod1.hashCode());
    			System.out.println("Object is saved or updated");
    	}//try with resources
    	catch (HibernateException he) {
    		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
    			tx.rollback();
    			System.out.println("Object is not saved or updated");
			he.printStackTrace();
		}//catch
    }//main
}//class
