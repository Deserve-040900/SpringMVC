package com.configs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pojos.Adminuser;
import com.pojos.Category;
import com.pojos.Product;
import com.pojos.Tag;

import jakarta.persistence.Query;

public class inquiryDemo {
	public static void main(String[] args) {
		SessionFactory f = HibernateUtils.getFactory();
		
		try (Session ss = f.openSession()){
			Category c = ss.get(Category.class, 2);
			Tag t1 = ss.get(Tag.class, 1);
			Tag t2 = ss.get(Tag.class, 2);
			
			Product p = new Product();
			p.setName("MacBook note pro 2023");
			p.setPrice(new BigDecimal(32000000));
			p.setCategoryId(c);
			
			List<Tag> t = new ArrayList<>();
			t.add(t1);
			t.add(t2);
			p.setTags(t);
			// open transaction to map all data to database
			ss.getTransaction().begin();
			ss.save(p);
			ss.getTransaction().commit();
		}
		
		//ss.close();
	}
}
