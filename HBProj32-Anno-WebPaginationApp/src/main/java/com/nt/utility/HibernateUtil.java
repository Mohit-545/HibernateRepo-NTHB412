//HibernateUtil.java
package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		//create and configure hb cfg file
		Configuration cfg = new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static Session getSession() {
		Session ses = null;
		if(factory!=null) {
			ses = factory.openSession();
		}
		return ses;
	}

}//class
