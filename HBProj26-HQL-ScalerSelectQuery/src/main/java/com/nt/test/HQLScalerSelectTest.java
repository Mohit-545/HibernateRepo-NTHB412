//HQLScalerSelectTest.java
package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil;

public class HQLScalerSelectTest {
    public static void main( String[] args ) {
        //get the SessionFactory and Session Object
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session ses = HibernateUtil.getSession();
    	try(factory;ses){
    		//(1) executing HQL Scaler Select Query (retrieving specific multiple column values) 
						Query query = ses.createQuery("select pid,pname,price from Product where price>=:min and price<=:max");
							query.setParameter("min", 500.0f);
							query.setParameter("max", 90000.0f);
    		//execute the HQL Query
    		List<Object[]> list = query.list();
    		//process the result ( can use lambda exp or method reference)
    		list.forEach(row -> {
    			for(Object val:row) {
    				System.out.print(val+"   ");
    			}
    			System.out.println();
    		});	
    		System.out.println();
    		System.out.println();
    		System.out.println();
    		//(1) executing HQL Scaler Select Query (retrieving specific Single column value)
    			Query query1 = ses.createQuery("select pname from Product where qty>=:min and qty<=:max");
    			query1.setParameter("min", 10.0f);
    			query1.setParameter("max", 20.0f);
    			//process the query
    			List<Object> list1 = query1.list();
    			list1.forEach(name ->{
    				System.out.println(name);
    			});
    	}//try
    	catch (Exception e) {
			e.printStackTrace();
		}//catch
    }//main
}//class
