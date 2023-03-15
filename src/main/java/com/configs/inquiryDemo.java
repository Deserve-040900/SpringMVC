package com.configs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pojos.Adminuser;
import com.pojos.Category;

public class inquiryDemo {
	public static void main(String[] args) {
		SessionFactory f = HibernateUtils.getFactory();
		
		try (Session ss = f.openSession()){			
			Category c = ss.get(Category.class, 7);
			ss.getTransaction().begin();
			ss.delete(c);
			ss.getTransaction().commit();
		}
		
		//ss.close();
	}
}
