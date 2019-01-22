package com.itversity.mongodbcrudexample.entities;
/*
 * OrderItem class is an entity which contains details about the items an Order have 
 */
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// @Document annotation explains which collection to refer to for OrderItem class
@Document(collection = "orderItems")
public class OrderItem {

	@Id
	public ObjectId _id;

	@Field("order_item_id")
	private Long orderItemId;

	@Field("order_item_order_id")
	private Long orderId;

	@Field("order_item_product_id")
	private Long productId;

	@Field("order_item_quantity")
	private Integer quantity;

	@Field("order_item_subtotal")
	private Double subtotal;

	@Field("order_item_product_price")
	private Double productPrice;

	public OrderItem() {
		super();
	}

	@PersistenceConstructor
	public OrderItem(ObjectId _id, Long orderItemId, Long orderId, Long productId, Integer quantity, Double subtotal,
			Double productPrice) {
		super();
		this._id = _id;
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.productPrice = productPrice;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", subtotal=" + subtotal + ", productPrice=" + productPrice + "]";
	}

}
