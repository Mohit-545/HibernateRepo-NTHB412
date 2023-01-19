//MergeObjectTestApproach2.java (client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil;

public class MergeObjectTestApproach2 {
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    		Transaction tx = null;
    		boolean flag = false;
    		
    	try{
    		//begin tx
    			tx = ses.beginTransaction();
    			//loads the objects in the L1 cache
    			Product prod = ses.get(Product.class, 1001);
    			if(prod!=null)
    				System.out.println(prod);
    			//update the product
    				Product prod1 = new Product();
    				prod1.setPid(1001);
    				prod1.setPname("Table");
    				prod1.setPrice(9560f);
    				prod1.setQty(20f);
    				//merge the product
    				Product prod2 = (Product)ses.merge(prod1);
    				System.out.println("Object is merged");
    				System.out.println(prod2);
    				flag = true;
    	}//try 
    	catch (HibernateException he) {
    		flag = false;
			he.printStackTrace();
		}//catch
    	finally {
			if(flag=true)
				tx.commit();
			else
				tx.rollback();
			
			//close the objects
			ses.close();
			factory.close();
		}
    }//main
}//class
