//OneToManyUniTest.java (client or main class)
package com.nt.test;

import com.nt.dao.CompanyImplDAO;
import com.nt.dao.ICompanyDAO;
import com.nt.utils.HibernateUtil;

public class OneToManyBiTest {

	public static void main(String[] args) {
		ICompanyDAO dao = new CompanyImplDAO();
		//dao.saveDataUsingParent();
		System.out.println();
		dao.saveDataUsingChild();
		System.out.println();
		//close SessionFactory 
		HibernateUtil.closeSessionFactory();
		

	}//main

}//class
