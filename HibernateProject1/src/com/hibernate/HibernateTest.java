package com.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		//user.setUserId(4);
		user.setUserName("Singh");
		user.setDate(new Date());
		user.setDescription("User Description");
		
		UserDetails user2 = new UserDetails();
		//user.setUserId(4);
		user2.setUserName("Ram");
		user2.setDate(new Date());
		user2.setDescription("Ram User Description");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
//		user = null;
//		
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		UserDetails user2 = (UserDetails)session.get(UserDetails.class, 4);
//		System.out.println("User Name : "+user2.getUserName());
//		
//		//HQL Query
//		Criteria query = session.createCriteria(UserDetails.class);
//	    List<UserDetails> userList = 	query.list();
//	    System.out.println(userList);
//	    
//	    //SQL Query
//	    List<UserDetails> userList2 = (List<UserDetails>)session.createSQLQuery("SELECT * FROM UserDetail").addEntity(UserDetails.class).list();
//	    System.out.println(userList2);
	}

}
