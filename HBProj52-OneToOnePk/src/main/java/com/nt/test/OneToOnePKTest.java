//OneToOnePKTest.java (client or main class)
package com.nt.test;


import com.nt.dao.IOneToOnePKDAO;
import com.nt.dao.OneToOnePKDAOImpl;
import com.nt.utils.HibernateUtil;

public class OneToOnePKTest {

	public static void main(String[] args) {
		IOneToOnePKDAO dao = new OneToOnePKDAOImpl();
		
		//dao.saveDataUsingParent();
		//dao.saveDataUsingChild();
		dao.loadDataUsingParent();
		System.out.println();
		
		//close SessionFactory 
		HibernateUtil.closeSessionFactory();
		

	}//main

}//class
