//PaginationTest1.java
package com.nt.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil;

public class PaginationTest1 {
    public static void main( String[] args ) {
    	//read input from end-user
    	Scanner scn = new Scanner(System.in);
    	System.out.print("Enter page size :: ");
    	int pageSize = scn.nextInt();
    	System.out.println();
        //get the SessionFactory and Session Object
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session ses = HibernateUtil.getSession();
    	Transaction tx = null;
    	try(factory;ses){
    		//get total record from database table
    		Query query1 = ses.createQuery("select count(*) from Product");
    		long totalRecords = (long) query1.getSingleResult();
    		long pageCount = totalRecords/pageSize;
	    		if(totalRecords%pageSize!=0)
	    			pageCount++;
	    		System.out.println("PageCount value :: "+pageCount);
    		//create HQL Query for Pagination
    		Query query2 = ses.createQuery("from Product");
    		for(int pageNo = 1; pageNo<=pageCount; pageNo++) {
    			System.out.println(pageNo+"/"+pageCount+" page records");
    			System.out.println("================");
    			//get start position for each page
    			int startposition = (pageNo*pageSize)-pageSize;
    			//set pagination params
    			query2.setFirstResult(startposition);
    			query2.setMaxResults(pageSize);
    			//execute the Query
	    		List<Product> list = query2.getResultList();
	    		//process the result
	    		list.forEach(System.out::println);
	    		System.out.println("--------------------------------------------------------------------------------------------------------------");
    		}//for
    	}//try
    	catch (HibernateException he) {
    		he.printStackTrace();
   			System.out.println("Problem in executing the Query");
		}//catch
    }//main
}//class
