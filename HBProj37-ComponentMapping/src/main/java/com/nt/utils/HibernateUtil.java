//HibernateUtil.java
package com.nt.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		System.out.println("HibernateUtil::static block");
		// create configuration object
			Configuration cfg = new Configuration();
		// Load and read HB cfg file
			cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		// build SessionFactory
			factory = cfg.buildSessionFactory();
	}//static block
	
	// static factory method for SessionFactory object
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	//static factory method for Session object
	public static Session getSession() {
		Session ses = null;
		// open session
			if(factory!=null) {
				ses = factory.openSession();
			}
			return ses;
	}
}//class
