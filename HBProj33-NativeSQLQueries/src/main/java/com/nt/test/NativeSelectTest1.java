//NativeSelectTest1.java
package com.nt.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil;

public class NativeSelectTest1 {
    public static void main( String[] args ) {
        //get the SessionFactory and Session Object
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session ses = HibernateUtil.getSession();
    	Transaction tx = null;
    	try(factory;ses){
    		//Scalar query (getting specific multiple col values)
    		NativeQuery query = ses.createNativeQuery("select pid,price from Product where price between ? and ?");
    		//map scalar query results with hibernate data types
    		query.addScalar("pid", StandardBasicTypes.INTEGER);
    		query.addScalar("price", StandardBasicTypes.FLOAT);
    		//set query param values
    		query.setParameter(1, 1000.0f);
    		query.setParameter(2, 55000.0f);
    		List<Object[]> list = query.getResultList();
    		list.forEach(record->{
    			for(Object val:record) {
    				System.out.print(val+"   ");
    			}
    			System.out.println();
    		});
    		//Scalar query (getting specific single col values)
    		NativeQuery query1	 = ses.createNativeQuery("select pid from Product where qty>=?1");
    		//map scalar query results with hibernate data types
    		query.addScalar("pid", StandardBasicTypes.INTEGER);
    		//set query param values
    		query1.setParameter(1, 20);
    		//execute the query
    		List<Integer> list1 = query1.getResultList();
    		list1.forEach(id->{
    			System.out.println(id);
    		});
    	}//try
    	catch (HibernateException he) {
    		he.printStackTrace();
    		System.out.println("Problem in executing the Query");
		}//catch
    	    	
    }//main
}//class
