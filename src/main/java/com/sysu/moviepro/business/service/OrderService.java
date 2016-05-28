package com.sysu.moviepro.business.service;

import java.util.List;

import com.sysu.moviepro.business.entity.Order;

public interface OrderService {
	public int createOrder(Order Order);
	public Order updateOrder(Order Order);
	public void deleteOrder(int id);
	public Order getOrder(int id);
	public List<Order> getAllOrders(); 
}
