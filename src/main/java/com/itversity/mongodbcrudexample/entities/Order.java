package com.itversity.mongodbcrudexample.entities;
/*
 * Order class is an entity which contains details about the order our client has placed.
 */
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//@Document annotation explains which collection to refer to for Order class
@Document(collection = "orders")
public class Order {

	@Id
	public ObjectId _id;

	@Field("order_id") // helps to map collection field to class variable name
	@Indexed(unique = true) // it says orderId will be indexed and it will have
							// unique values
	private Long orderId;

	@Field("order_date")
	private String orderDate;

	@Field("order_customer_id")
	private Long orderCustomerId;

	@Field("order_status")
	private String orderStatus;

	private List<OrderItem> orderItems;

	public Order() {
		super();
	}

	// this annotation marks a constructor to use when instantiating the object from the
	// database. Constructor arguments are mapped by name to the key values
	@PersistenceConstructor
	public Order(ObjectId _id, Long orderId, String orderDate, Long orderCustomerId, String orderStatus,
			List<OrderItem> orderItems) {
		super();
		this._id = _id;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderCustomerId = orderCustomerId;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Long getOrderCustomerId() {
		return orderCustomerId;
	}

	public void setOrderCustomerId(Long orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderCustomerId=" + orderCustomerId
				+ ", orderStatus=" + orderStatus + "]";
	}
}
