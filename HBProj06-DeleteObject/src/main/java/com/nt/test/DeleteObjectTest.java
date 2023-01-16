////DeleteObjectTest.java (client/main class)
//package com.nt.test;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import com.nt.entity.Product;
//
//public class DeleteObjectTest {
//    public static void main( String[] args ){
//        // get the configuration object
//    		Configuration cfg = new Configuration();
//    	// configure the file
//    		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
//    	//build the Session
//    		SessionFactory factory = cfg.buildSessionFactory();
//    	// open the session
//    		Session ses = factory.openSession();
//    		Transaction tx = null;
//    		try(factory;ses){
//    			//begin the transaction
//    			tx = ses.beginTransaction();
//    			//prepare the entity class object
//    			Product prod = new Product();
//    			//set id value for which the data is to be deleted
//    			prod.setPid(1007);
//    			//delete the data
//    			ses.delete(prod);
//    			//commit the tx
//    			tx.commit();
//    			System.out.println("Object have been deleted ");
//    		}//try with resource (java 9 syntax)
//    		catch (Exception e) {
//				if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
//					tx.rollback();
//					System.out.println("Object is not deleted");
//				}//if
//				e.printStackTrace();
//			}//catch
//    }//main
//}//class
