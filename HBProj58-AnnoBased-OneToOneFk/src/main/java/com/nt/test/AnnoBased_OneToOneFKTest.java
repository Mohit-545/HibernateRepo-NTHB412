//AnnoBased_OneToOneFKTest.java (client or main class)
package com.nt.test;


import com.nt.dao.IOneToOneFKDAO;
import com.nt.dao.OneToOneFKDAOImpl;
import com.nt.utils.HibernateUtil;

public class AnnoBased_OneToOneFKTest {

	public static void main(String[] args) {
		IOneToOneFKDAO dao = new OneToOneFKDAOImpl();
		
		//dao.saveDataUsingChild();
		dao.loadDataUsingChild();
		System.out.println();
		
		//close SessionFactory 
		HibernateUtil.closeSessionFactory();
		

	}//main

}//class
