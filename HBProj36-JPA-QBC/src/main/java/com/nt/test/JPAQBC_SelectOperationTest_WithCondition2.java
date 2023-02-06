//JPAQBC_SelectOperationTest_WithCondition2.java
package com.nt.test;

import java.util.List;


import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class JPAQBC_SelectOperationTest_WithCondition2 {
    public static void main( String[] args ) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ses = HibernateUtil.getSession();
        try(factory;ses){
        	// create CriteriaBuilder obj
        	CriteriaBuilder ctBuilder = ses.getCriteriaBuilder();
        	// create CriteriaQuery obj
        	CriteriaQuery<Product> ctQuery = ctBuilder.createQuery(Product.class);
        	// create root obj specifying the from operation (with conditions)
        	Root<Product> root = ctQuery.from(Product.class);  //performs Select * from Product Query
        	//apply where  clause condition
        	ctQuery.select(root).where(ctBuilder.like(root.get("pname") , "C%"));
        	// create Query obj having CriteriaQuery obj
        	Query query = ses.createQuery(ctQuery);
        	//execute the QBC logic
        	List<Product> list = query.getResultList();
        	//process the result
        	list.forEach(System.out::println);
        	
        }//try
        catch (Exception e) {
			e.printStackTrace();
		}//catch
    }//method
}//class
