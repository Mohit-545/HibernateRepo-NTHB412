//HibernateUtil_Oracle.java
package com.nt.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil_Oracle {
private static SessionFactory factory;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("com/nt/cfgs/hibernate-oracle.cfg.xml");
		factory = cfg.buildSessionFactory();
	}//static block
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static Session getSession() {
		Session ses = null;
		if(factory!=null) {
			ses = factory.openSession();
		}//if
		return ses;
	}


}//class
