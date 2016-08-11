package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;

@Repository(value= "CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired  //no need to create object of session factory ...automatically created
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;		
	}
	@Transactional
	public boolean save(Category category) {
		// TODO Auto-generated method stub
		try{
		sessionFactory.getCurrentSession().save(category);
		return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
			}catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	@Transactional
	public boolean delete(Category category) {  //since object is given 
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(category);
			return true;
			}catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

		public Category get(String id) {
		// TODO Auto-generated method stub  selct * from category where id = '101'
		String hql = "from Category where id= " + " ' " + id + " ' ";  //category is d domain object name not table name
		
		Query query = SessionFactory.getCurrentSession().createQuery(hql);
		List <Category> list = query.list();
		
		if(list==null)
		{
		return null;
	}else
	{ return list.get(0);
	}
	}
	public List<Category> list() {
		// TODO Auto-generated method stub 
		String hql = " from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  //to add try catch right click surround with
		return query.list();
		
	}

}
