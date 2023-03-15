package com.configs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pojos.Adminuser;
import com.pojos.Category;

import jakarta.persistence.Query;

public class inquiryDemo {
	public static void main(String[] args) {
		SessionFactory f = HibernateUtils.getFactory();
		
		try (Session ss = f.openSession()){
			Query q = ss.createQuery("From Category");
			List<Category> rs = q.getResultList();
			
			rs.forEach(c -> System.out.printf("%d - %s \n", c.getId(), c.getName()));
		}
		
		//ss.close();
	}
}
