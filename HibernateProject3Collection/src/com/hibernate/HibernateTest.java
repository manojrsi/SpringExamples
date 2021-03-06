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
		
		Address homeAddress = new Address();
		homeAddress.setStreet("Home 1st Street");
		homeAddress.setCity("Home  Noida");
		homeAddress.setState("Home UP");
		homeAddress.setPincode("Home 201301");
		
		Address officeAddress = new Address();
		officeAddress.setStreet("Office 1st Street");
		officeAddress.setCity("Office Noida");
		officeAddress.setState("Office UP");
		
		// As this change is done in Address entity @Column(name="PIN_CODE", insertable=false, updatable= false)
		//But still if we set pincode value no error will occur, hibernate will simply ignore it
		//officeAddress.setPincode("Office 201301");
		
		
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
