//OneToManyUniTest.java (client or main class)
package com.nt.test;

import com.nt.dao.IPersonDetailsDAO;
import com.nt.dao.PersonDetailsImplDAO;
import com.nt.utils.HibernateUtil;

public class OneToManyUniTest {

	public static void main(String[] args) {
		IPersonDetailsDAO dao = new PersonDetailsImplDAO();
		//dao.saveDataUsingParent();
		System.out.println();
		//dao.loadDataUsingParent();
		System.out.println();
		//dao.addChildToExistingParent();
		System.out.println();
		//dao.deleteAllChildsOfAParent();
		System.out.println();
		dao.deleteOneChildFromCollectionOfChildsOfAParent();
		System.out.println();
		dao.deleteParentAndItsChilds();
		System.out.println();
				
		//close SessionFactory 
		HibernateUtil.closeSessionFactory();
		

	}//main

}//class
