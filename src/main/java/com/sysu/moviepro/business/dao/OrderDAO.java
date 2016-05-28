package com.sysu.moviepro.business.dao;

import com.sysu.moviepro.business.entity.Order;

import java.util.List;

public interface OrderDAO {
	public int createOrder(Order Order);
	public Order updateOrder(Order Order);
	public void deleteOrder(int id);
	public Order getOrder(int id);
	public List<Order> getAllOrders();
}
