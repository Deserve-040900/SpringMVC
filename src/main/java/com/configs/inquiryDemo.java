package com.configs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pojos.Category;
import com.pojos.Product;
import com.pojos.Tag;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class inquiryDemo {
	public static void main(String[] args) {
		SessionFactory f = HibernateUtils.getFactory();
		
		try (Session ss = f.openSession()){
			CriteriaBuilder cb = ss.getCriteriaBuilder();
			CriteriaQuery<Product> query = cb.createQuery(Product.class);
			Root rt = query.from(Product.class);
			query.select(rt);
			
//			Predicate pr1 = cb.like(rt.get("name").as(String.class), "%iPad%");
			Predicate pr2 = cb.greaterThanOrEqualTo(rt.get("price").as(BigDecimal.class), new BigDecimal(20000000));
			query = query.where(pr2);
			
			Query q = ss.createQuery(query);
			List<Product> prod = q.getResultList();
			prod.forEach(p -> {
				System.out.printf("%d - %s - %.1f VND - %s \n", p.getId(), p.getName(), p.getPrice(), p.getCategoryId().getName());
			});
		}
		
		//ss.close();
	}
}
