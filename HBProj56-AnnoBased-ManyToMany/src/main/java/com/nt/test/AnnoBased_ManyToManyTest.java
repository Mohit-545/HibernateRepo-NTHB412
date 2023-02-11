//AnnoBased_OneToManyUniTest.java (client or main class)
package com.nt.test;

import com.nt.dao.HospitalImplDAO;
import com.nt.dao.IHospitalDAO;
import com.nt.utils.HibernateUtil;

public class AnnoBased_ManyToManyTest {

	public static void main(String[] args) {
		IHospitalDAO dao = new HospitalImplDAO();
		
		//dao.saveDataUsingParent();
		//dao.saveDataUsingChild();
		dao.loadDataUsingParent();
		System.out.println();
		
		//close SessionFactory 
		HibernateUtil.closeSessionFactory();
		

	}//main

}//class
