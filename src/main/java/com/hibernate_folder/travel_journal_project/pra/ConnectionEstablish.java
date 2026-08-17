package com.hibernate_folder.travel_journal_project.pra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ConnectionEstablish {

	static Session session = null;
	
	// Private constructor to prevent object creation
	private ConnectionEstablish() {
		
	}
	//Use Singleton for provide same Object to All ...
	// Create and return Hibernate Session
	public static Session getConnection(String address) {
		
		// Create session only if it does not already exist
		if(session == null) {
			Configuration config = new Configuration();
			
			// Load Hibernate configuration
			config.configure(address);
			
			// Create SessionFactory and open Session
			SessionFactory factory = config.buildSessionFactory();
			session = factory.openSession();
		}
	  
		return session;	
	}
}