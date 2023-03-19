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
			CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
			Root rP = query.from(Product.class);
			Root rC = query.from(Category.class);			
			Predicate p = cb.equal(rP.get("category"), rC.get("id")); // inner join table
			
			query = query.where(p);
			query.multiselect(rC.get("id"), rC.get("name"), cb.count(rP.get("id")));
			query.groupBy(rC.get("id"));
			query.orderBy(cb.asc(rC.get("name")));
			
			Query q = ss.createQuery(query);
			List<Object[]> rs = q.getResultList();
			rs.forEach(o -> {
				System.out.printf("%d - %s - %d \n", o[0], o[1], o[2]);
			});
		}
		
		//ss.close();
	}
}
