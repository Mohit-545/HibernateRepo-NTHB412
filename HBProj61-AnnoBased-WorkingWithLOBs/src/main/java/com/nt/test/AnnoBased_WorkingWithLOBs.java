//AnnoBased_WorkingWithLOBs.java (client or main class)
package com.nt.test;

import com.nt.dao.CompanyImplDAO;
import com.nt.dao.ICompanyDAO;
import com.nt.utils.HibernateUtil;

public class AnnoBased_WorkingWithLOBs {

	public static void main(String[] args) {
		ICompanyDAO dao = new CompanyImplDAO();
		
		//dao.saveData();
		System.out.println();
		
		dao.loadData(); 
		System.out.println();
		
		//close SessionFactory 
		HibernateUtil.closeSessionFactory();
		

	}//main

}//class
