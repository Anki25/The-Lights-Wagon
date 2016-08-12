package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;

@Repository(value= "ProductDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired  //no need to create object of session factory ...automatically created
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;		
	}
	@Transactional
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		try{
		sessionFactory.getCurrentSession().save(product);
		return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
			}catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	@Transactional
	public boolean delete(Product product) {  //since object is given 
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(product);
			return true;
			}catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}
	@SuppressWarnings("deprecation")
			public Product get(String id) {
		// TODO Auto-generated method stub  selct * from product where id = '101'
		String hql = "from Product where id= " + " ' " + id + " ' ";  //product is d domain object name not table name
		
		Query query = SessionFactory.getCurrentSession().createQuery(hql);
		List <Product> list = query.list();
		
		if(list==null)
		{
		return null;
	}else
	{ return list.get(0);
	}
	}
	public List<Product> list() {
		// TODO Auto-generated method stub 
		String hql = " from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  //to add try catch right click surround with
		return query.list();
		
	}

}
