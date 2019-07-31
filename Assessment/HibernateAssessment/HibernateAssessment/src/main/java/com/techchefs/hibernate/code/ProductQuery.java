package com.techchefs.hibernate.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import lombok.extern.java.Log;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.techchefs.hibernate.dto.ProductBean;
import com.techchefs.hibernate.util.HibernateUtil;

public class ProductQuery {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(ProductBean.class).add(Restrictions.gt("Price", (double)100));
		List<ProductBean> beans = criteria.list();
		
		for (ProductBean productbean : beans) {
			System.out.println("Item price more than 100 rs is as follows -> ");
			System.out.println("ProductId:" + productbean.getProductId());
			System.out.println("Product Name:" + productbean.getProductName());
			System.out.println("Product Price:" + productbean.getPrice());
			System.out.println("Product Color:" + productbean.getColor());
			System.out.println("Product Weight:" + productbean.getWeight());
		}
		
		Criteria criteriaA = session.createCriteria(ProductBean.class).add(Restrictions.sqlRestriction("ProductName like \"A%\""));
		List<ProductBean> beanA = criteriaA.list();
		
		for (ProductBean productbean : beanA) {
			System.out.println("Item price name starts with A -> ");
			System.out.println("ProductId:" + productbean.getProductId());
			System.out.println("Product Name:" + productbean.getProductName());
			System.out.println("Product Price:" + productbean.getPrice());
			System.out.println("Product Color:" + productbean.getColor());
			System.out.println("Product Weight:" + productbean.getWeight());
		}
		
		session.close();
	}

}
