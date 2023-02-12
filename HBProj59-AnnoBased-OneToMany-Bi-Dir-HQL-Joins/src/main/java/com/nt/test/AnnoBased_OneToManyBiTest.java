//OneToManyUniTest.java (client or main class)
package com.nt.test;

import com.nt.dao.CompanyImplDAO;
import com.nt.dao.ICompanyDAO;
import com.nt.utils.HibernateUtil;

public class AnnoBased_OneToManyBiTest {

	public static void main(String[] args) {
		ICompanyDAO dao = new CompanyImplDAO();
		
		dao.loadDataUsingJoinsParentToChild();
		System.out.println();
		System.out.println();
		
		dao.loadDataUsingJoinsChildToParent(); 
		System.out.println();
		
		//close SessionFactory 
		HibernateUtil.closeSessionFactory();
		

	}//main

}//class
