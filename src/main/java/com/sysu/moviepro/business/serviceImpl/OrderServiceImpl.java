package com.sysu.moviepro.business.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.moviepro.business.entity.Order;
import com.sysu.moviepro.business.entity.Ticket;
import com.sysu.moviepro.business.entity.User;
import com.sysu.moviepro.business.service.OrderService;
import com.sysu.moviepro.business.dao.OrderDAO;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	public OrderServiceImpl() {
		System.out.println("OrderServiceImpl()");
	}

	@Autowired
	private OrderDAO OrderDAO;
	
	@Override
	public int createOrder(Order Order) {
		// TODO Auto-generated method stub
		return OrderDAO.createOrder(Order);
	}

	@Override
	public Order updateOrder(Order Order) {
		// TODO Auto-generated method stub
		return OrderDAO.updateOrder(Order);
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		OrderDAO.deleteOrder(id);
	}

	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		return OrderDAO.getOrder(id);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return OrderDAO.getAllOrders();
	}

	@Override
	public int createOrderByTickets(User user, Set<Ticket> tickets) {
		// TODO Auto-generated method stub
		Order order = new Order();
		int cost = 0;
		for (Ticket ticket : tickets) {
			ticket.setOrder(order);
			cost += ticket.getPrice();
		}
		order.setCost(cost);
		order.setUser(user);
		order.setTickets(tickets);
		int id = OrderDAO.createOrder(order);
		return id;
	}
}
