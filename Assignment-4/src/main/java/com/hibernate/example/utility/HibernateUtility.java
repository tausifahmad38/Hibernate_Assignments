package com.hibernate.example.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	
		private static final SessionFactory sessionFactory = buildSessionFactory();

		private static SessionFactory buildSessionFactory() {
			try {
				// Use hibernate.cfg.xml to get a SessionFactory
				return new Configuration().configure().buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}

		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public static void shutdown() {
			getSessionFactory().close();
		}
	


}
