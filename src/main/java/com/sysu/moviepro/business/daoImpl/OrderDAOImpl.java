package com.sysu.moviepro.business.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.moviepro.business.dao.OrderDAO;
import com.sysu.moviepro.business.entity.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createOrder(Order Order) {
		// TODO Auto-generated method stub
		Integer id = (Integer) sessionFactory.getCurrentSession().save(Order);
		return id;
	}

	@Override
	public Order updateOrder(Order Order) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(Order);
		sessionFactory.getCurrentSession().flush();
		return Order;
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		Order Order = new Order();
		Order.setId(id);
		sessionFactory.getCurrentSession().delete(Order);
	}

	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		Order Order = (Order) sessionFactory.getCurrentSession().get(Order.class, id);
		return Order;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(" From Order Order ").list();
	}
}
