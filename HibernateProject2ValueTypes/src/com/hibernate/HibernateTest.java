package com.hibernate;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Address;
import com.hibernate.model.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		//user.setUserId(4);
		user.setUserName("Singh");
		user.setDate(new Date());
		user.setDescription("User Description");

		
		Address address1 = new Address();
		address1.setStreet("List First 1st Street");
		address1.setCity("List First Noida");
		address1.setState("List First  UP");
		address1.setPincode("List First  201301");
		
		Address address2 = new Address();
		address2.setStreet("List Second 1st Street");
		address2.setCity("List Second  Noida");
		address2.setState("List Second  UP");
		
		user.getAddressSet().add(address1);
		user.getAddressSet().add(address2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
	}

}
