package com.configs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pojos.Adminuser;
import com.pojos.Category;

public class inquiryDemo {
	public static void main(String[] args) {
		SessionFactory f = HibernateUtils.getFactory();
		
		try (Session ss = f.openSession()){
			Category c = new Category(); // transient
			c.setName("Tablet");//			
			ss.save(c); // insert
		}
		
		//ss.close();
	}
}
