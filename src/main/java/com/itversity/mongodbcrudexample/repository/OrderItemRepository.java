package com.itversity.mongodbcrudexample.repository;

/*
 * OrderItemRepository is the repository layer for handling CRUD operations for OrderItem.
 */

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.itversity.mongodbcrudexample.entities.OrderItem;

public interface OrderItemRepository extends MongoRepository<OrderItem, Long> {

	List<OrderItem> findByOrderId(Long id);

	public void deleteByOrderId(Long orderId);
}
