package com.itversity.mongodbcrudexample.service;

/*
 * OrderService is the service layer for handling CRUD operations for Order.
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itversity.mongodbcrudexample.entities.Order;
import com.itversity.mongodbcrudexample.exception.MessageCode;
import com.itversity.mongodbcrudexample.exception.MongoDBCrudMessage;
import com.itversity.mongodbcrudexample.exception.OrderNotPresentException;
import com.itversity.mongodbcrudexample.repository.OrderItemRepository;
import com.itversity.mongodbcrudexample.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public List<Order> getOrders() {

		List<Order> orders = new ArrayList<>();
		orders = orderRepository.findAll();

		for (Order order : orders) {
			order.setOrderItems(orderItemRepository.findByOrderId(order.getOrderId()));
		}

		return orders;
	}

	public Order getOrder(Long id) {

		Order order = orderRepository.findByOrderId(id);
		if (order != null)
			order.setOrderItems(orderItemRepository.findByOrderId(id));
		else {
			throw new OrderNotPresentException(MessageCode.ID_NOT_EXISTS, "Orer with id " + id + " is not present");
		}

		return order;
	}

	public Order saveOrder(Order order) {

		order.setOrderId(orderRepository.save(order).getOrderId());
		orderItemRepository.saveAll(order.getOrderItems());

		return order;
	}

	public MongoDBCrudMessage deleteOrder(Long id) {

		this.getOrder(id);
		orderItemRepository.deleteByOrderId(id);
		orderRepository.deleteByOrderId(id);

		return new MongoDBCrudMessage(MessageCode.ID_DELETED_SUCCESSFULLY,
				"Order with id " + id + " deleted successfully.");
	}

	public void updateOrder(Order order) {

		orderRepository.save(order);
		orderItemRepository.saveAll(order.getOrderItems());
	}
}
