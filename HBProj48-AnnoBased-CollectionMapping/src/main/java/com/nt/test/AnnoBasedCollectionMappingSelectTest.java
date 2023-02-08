//CollectionMappingSelectTest.java (client class)
package com.nt.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.PersonDetails;
import com.nt.utils.HibernateUtil;

public class AnnoBasedCollectionMappingSelectTest{
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    	try(factory;ses){
    		Query query = ses.createQuery("from PersonDetails");
    		List<PersonDetails> list = query.getResultList();
    		list.forEach(pd->{
    			System.out.println("Person's Info => "+pd.getPid()+"  "+pd.getPname()+"  "+pd.getPaddrs());
    			//nickNames info
    			List<String> nickNames = pd.getNickNames();
    				System.out.println("NickNames are => "+nickNames.toString());
    			//friends info
    				List<String> friends = pd.getFriends();
    					System.out.println("Friends are => "+friends.toString());
    			//Contact no info
    				Set<Long> contactNumbers = pd.getContactNumbers();
    					System.out.println("ContactNumbers are => "+contactNumbers.toString());
    			//idDetails info
    				Map<String, Long> idDetails = pd.getIdDetails();
    					System.out.println("idDetails are => "+idDetails.toString());
    		});
    	}//try
    	catch (HibernateException he) {
			he.printStackTrace();
		}//catch
    }//main
}//class
