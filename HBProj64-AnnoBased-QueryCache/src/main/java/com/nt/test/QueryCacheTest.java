//QueryCacheTest.java (main/client class)
package com.nt.test;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nt.entity.Product;

public class QueryCacheTest {
    public static void main( String[] args )  {
        //BootStrap or Activate the Hibernate
    		Configuration cfg = new Configuration();
    	//specify the hibernate cfgs file name and location
    		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
    	//build SessionFactory obj with all the services  specified in the cfgs file and mapping file
    		SessionFactory factory = cfg.buildSessionFactory();
		//create Session object
    		Session ses = factory.openSession();
  
    		//try with resource java 9 syntax
    		try (factory;ses){
    			Query query = ses.createQuery("from Product");
    			query.setCacheable(true);
    			query.setCacheRegion("region1");
    			List<Product> list1 = query.getResultList();
    			list1.forEach(System.out::println);
    			System.out.println("---------------------------------------------------------------");
    			List<Product> list2 = query.getResultList();
    			list2.forEach(System.out::println);
    					
    		}//try
    		catch (HibernateException he) {
    			he.printStackTrace();
    		}//catch
    		catch (Exception e) {
				e.printStackTrace();
			}
    		
    }//main
}//class
