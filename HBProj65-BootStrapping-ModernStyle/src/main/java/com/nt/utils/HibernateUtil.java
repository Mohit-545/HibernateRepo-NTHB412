//HibernateUtil.java
package com.nt.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolver;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		try {
			// create configuration object
			Configuration cfg = new Configuration();
			//create ServiceRegistryBuilder
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			//create Service Registry
			StandardServiceRegistry registry = builder.configure("com/nt/cfgs/hibernate.cfg.xml").build();
			// build SessionFactory using Registry
			factory = cfg.buildSessionFactory(registry);
			System.out.println(registry.getParentServiceRegistry().getClass()+"   "+registry.getService(ConnectionProvider.class)+"   "
												+registry.getService(ClassLoaderService.class)+"   "+registry.getService(DialectResolver.class));
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
		}//catch
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		
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
