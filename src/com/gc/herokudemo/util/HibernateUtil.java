/**
 * 
 */
package com.gc.herokudemo.util;

import java.net.URI;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Maurice Tedder
 * This code is based on code from
 * Ref:http://docs.jboss.org/hibernate/core/3.3/reference/en/html/tutorial.html#tutorial-firstapp-helpers
 *
 * This is a singleton needed to prevent recreating connections that exceed the connection
 */
public class HibernateUtil {

	
	private static SessionFactory factory = buildSessionFacotry();
	
	/**
	 * Private constructor
	 */
	private HibernateUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Build session factory
	 */
	private static SessionFactory buildSessionFacotry(){
		try {
			Configuration cfg = new Configuration();			
			URI uri = new URI(System.getenv("DATABASE_URL"));			
			//URI uri = new URI(url);
			String[] userInfo = uri.getUserInfo().split(":");// get username and
																// password from
																// uri string
			String username = userInfo[0];
			String password = userInfo[1];
			String dbURL = "jdbc:postgresql://" + uri.getHost() + ":" + uri.getPort() + uri.getPath();//Use this part to ru locally + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

			cfg.setProperty("hibernate.connection.url", dbURL);
			cfg.setProperty("hibernate.connection.username", username);
			cfg.setProperty("hibernate.connection.password", password);			
			return cfg.configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}		
	}
	/*
	 * Method controlling access to sesssion foactory
	 */
	public static SessionFactory getSessionFactory(){		
		return factory;
	}
}
