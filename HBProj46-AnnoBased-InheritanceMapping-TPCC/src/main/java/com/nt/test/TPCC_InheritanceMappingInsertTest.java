//TPSH_InheritanceMappingInsertTest.java (client class)
package com.nt.test;

import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.utils.HibernateUtil;

public class TPCC_InheritanceMappingInsertTest {
    public static void main( String[] args ) {
    	//using utility methods of HibernateUtil class to get SessionFactory and Session objects
        // get SessionFactory object
    		SessionFactory factory = HibernateUtil.getSessionFactory();
    	// get Session Object
    		Session ses = HibernateUtil.getSession();
    		Transaction tx = null;
    	try(factory;ses){
    		//prepare object
    		CardPayment card = new CardPayment(2456325625874785L, "DEBIT", "VISA");
    		card.setAmount(225000.0); card.setTxDate(LocalDateTime.of(2023, 02, 05, 11, 26));
    		
    		ChequePayment cheque = new ChequePayment(958795L, "Self");
    		cheque.setAmount(500000.0); cheque.setTxDate(LocalDateTime.of(2023, 01, 25, 15, 45));
    		
    		//begin tx
    			tx = ses.beginTransaction();
    		//save objects
    			ses.save(cheque);		ses.save(card);
    			//commit TX
    			tx.commit();
    	}//try with resources
    	catch (HibernateException he) {
    		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
    			tx.rollback();
    			System.out.println("Object is not saved or updated");
			he.printStackTrace();
		}//catch
    }//main
}//class
