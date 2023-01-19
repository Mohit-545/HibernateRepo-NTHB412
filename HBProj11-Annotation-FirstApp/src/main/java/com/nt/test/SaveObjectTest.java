//SaveObjectTest.java (client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Movie;
import com.nt.utils.HibernateUtil;

public class SaveObjectTest {
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    		Transaction tx = null;
    	//try with resources
    		try(factory;ses){
    			//begin Tx
    			tx = ses.beginTransaction();
    			//create and save object
//    			Movie movie = new Movie();
//    			movie.setMid(1103); movie.setMname("Pushpa"); //movie.setHero("Prabhas"); movie.setBudget(200.0f);
//    			ses.save(movie);
//    			Movie m = ses.get(Movie.class, 1101);
//    			if(m!=null)
//    				System.out.println(m);
//    			else
//    				System.out.println("Object not found");
    			//get the object
    			Movie movie = ses.get(Movie.class, 1103);
    			if(movie==null) {
    				System.out.println("Object not found");
    				return;
    			}
    			else {
    				Movie movie1 = new Movie();
    				movie1.setMid(1103);
    				movie1.setMname("Pushpa");
    				movie1.setHero("Allu Arjun");
    				movie1.setBudget(300f);
    				Movie movie2 = (Movie)ses.merge(movie1);
    				tx.commit();
    				System.out.println("Object is saved");
    				System.out.println("Updated Object :: "+movie2);
    			}
    	 	}//try
    	catch (HibernateException he) {
	    	if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
	    		tx.rollback();
	    		System.out.println("Object is not saved");
	    	}//if
			he.printStackTrace();
		}//catch
    }//main
}//class
