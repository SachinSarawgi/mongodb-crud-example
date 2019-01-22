package com.itversity.mongodbcrudexample.controllers;

/*
 * OrderController is the controller layer for handling CRUD operations for Order.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itversity.mongodbcrudexample.entities.Order;
import com.itversity.mongodbcrudexample.exception.MongoDBCrudMessage;
import com.itversity.mongodbcrudexample.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderSrevice;

	@GetMapping("/")
	public ResponseEntity<List<Order>> getOrders() {

		return new ResponseEntity<>(orderSrevice.getOrders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Long id) {

		return new ResponseEntity<>(orderSrevice.getOrder(id), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {

		return new ResponseEntity<>(orderSrevice.saveOrder(order), HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<String> updateOrder(@RequestBody Order order) {

		orderSrevice.updateOrder(order);
		return new ResponseEntity<>("Order and OrderItems updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MongoDBCrudMessage> deleteOrder(@PathVariable Long id) {
		
		return new ResponseEntity<>(orderSrevice.deleteOrder(id), HttpStatus.OK);
	}
}
