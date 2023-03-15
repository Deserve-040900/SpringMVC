package com.configs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pojos.Adminuser;
import com.pojos.Category;

public class inquiryDemo {
	public static void main(String[] args) {
		SessionFactory f = HibernateUtils.getFactory();
		
		try (Session ss = f.openSession()){			
			Category c = ss.get(Category.class, 7); // persistent
			c.setName("GAMING");	
			ss.getTransaction().begin(); // open transaction
			ss.save(c); // update
			ss.getTransaction().commit(); // push data on cache to DB
		}
		
		//ss.close();
	}
}
