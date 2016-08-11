package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.HibernateException;

/* import javax.transaction.TransactionScoped;
import javax.transaction.Transactional; */

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired  
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;		
	}
	
	@Transactional
	public boolean save(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	public boolean update(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	public boolean delete(Supplier supplier) {     //(String id) since id is given object is created
		// TODO Auto-generated method stub
		/* Supplier supplier = new Supplier();
		supplier.setId(id);
		sessionFactory.getCurrentSession().delete(supplier); */
		try{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			}catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	
	}

	public Supplier get(String id) {
		// TODO Auto-generated method stub
        String hql = "from Category where id= " + " ' " + id + " ' ";  //category is d domain object name not table name
		Query query = SessionFactory.getCurrentSession().createQuery(hql);
		List <Category> list = query.list();
		
		return null;
	}

	public List<Supplier> list() {
		// TODO Auto-generated method stub
		
		return null;
	}

	

}
