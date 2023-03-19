package com.configs;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pojos.Adminuser;
import com.pojos.Category;
import com.pojos.Product;

import jakarta.persistence.Query;

public class inquiryDemo {
	public static void main(String[] args) {
		SessionFactory f = HibernateUtils.getFactory();
		
		try (Session ss = f.openSession()){
			Category c = ss.get(Category.class, 5); // persistent object
			
			Product p = new Product();
			p.setName("iPad mini 2023");
			p.setPrice(new BigDecimal(12000000));
			p.setCategoryId(c);
			
			ss.save(p);
		}
		
		//ss.close();
	}
}
