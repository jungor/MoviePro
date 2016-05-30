package com.sysu.moviepro.business.service;

import java.util.List;
import java.util.Set;

import com.sysu.moviepro.business.entity.Order;
import com.sysu.moviepro.business.entity.Ticket;
import com.sysu.moviepro.business.entity.User;

public interface OrderService {
	public int createOrder(Order Order);
	public Order updateOrder(Order Order);
	public void deleteOrder(int id);
	public Order getOrder(int id);
	public List<Order> getAllOrders(); 
	
	public int createOrderByTickets(User user, Set<Ticket> tickets);
}
