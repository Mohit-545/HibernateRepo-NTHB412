//L2CacheTest.java (main/client class)
package com.nt.test;

import javax.persistence.Cache;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class L2CacheTest {
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
    				//Load Object using getMethod()
    					Product prod = ses.get(Product.class, 1005); // loads from DB and keeps in L1 and L2 cache
    					System.out.println(prod);
    					Product prod1 = ses.get(Product.class, 1005);	//loads from L1 cache
    					System.out.println(prod1);
    					System.out.println("--------------------------------------------------");
    					ses.evict(prod1);	//removes prod1 from L1 cache
    					Product prod2 = ses.get(Product.class, 1005); // loads from L2 cache and keeps in L1 cache
    					System.out.println(prod2);
    					System.out.println("-------------------------------------------------------");
    					ses.clear();  // removes all from L1 cache
    					Cache cache = factory.getCache();
    					cache.evictAll();  //emptying L2 cache
    					Product prod3 = ses.get(Product.class, 1005); // loads from DB and keeps in L1 and L2 cache
    					System.out.println(prod3);
    					
    		}//try
    		catch (HibernateException he) {
    			he.printStackTrace();
    		}//catch
    		catch (Exception e) {
				e.printStackTrace();
			}
    		
    }//main
}//class
