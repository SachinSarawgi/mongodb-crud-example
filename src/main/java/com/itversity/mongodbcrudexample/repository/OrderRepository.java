package com.itversity.mongodbcrudexample.repository;

/*
 * OrderRepository is the repository layer for handling CRUD operations for Order.
 */

import org.springframework.data.mongodb.repository.MongoRepository;

import com.itversity.mongodbcrudexample.entities.Order;

public interface OrderRepository extends MongoRepository<Order, Long> {

	public Order findByOrderId(Long orderId);

	public void deleteByOrderId(Long orderId);
}
