//TransferProductTest.java (Client class)
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utils.HibernateUtil_MySql;
import com.nt.utils.HibernateUtil_Oracle;

public class TransferProductTest {
    public static void main( String[] args ) {
    	//get Session and SessionFactory Objects of both DB S/W
    	SessionFactory oracleFactory = HibernateUtil_Oracle.getSessionFactory();
    	SessionFactory mysqlFactory = HibernateUtil_Oracle.getSessionFactory();
    	Session oracleSes = HibernateUtil_Oracle.getSession();
    	Session mysqlSes = HibernateUtil_MySql.getSession();
    	Transaction mysqlTx = null;
    	try(oracleFactory;oracleSes;mysqlFactory;mysqlSes){
    		//get the Object /record from Oracle DB s/w
    		Product oracleProd = oracleSes.get(Product.class, 1003);
    		//begin the Tx
    		mysqlTx = mysqlSes.beginTransaction();
    		//transfer the Object to mysql DB s/w
    		Integer idVal = (Integer) mysqlSes.save(oracleProd);
    		//commit the Tx
    		mysqlTx.commit();
    		System.out.println("Object/Record is transfered from Oracle to MySql DB s/w");
    	}//try
    	catch (HibernateException he) {
    		if(mysqlTx!=null && mysqlTx.getStatus()!=null && mysqlTx.getRollbackOnly()) {
    			mysqlTx.rollback();
    			System.out.println("Object/Record is not transfered from Oracle to MySql DB s/w............Some Internal Problem!!!!!");
    		}//if
    		he.printStackTrace();
		}//catch
    }//main
}//class
