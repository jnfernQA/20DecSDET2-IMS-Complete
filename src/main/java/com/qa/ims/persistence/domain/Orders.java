package com.qa.ims.persistence.domain;

import java.util.ArrayList;

import java.util.List;

public class Orders {
	
	private Long orderId;
	private Customer customer;
	private double orderValue;
	private List<Items> orderItems = new ArrayList<>();
	
	
	public Orders(Customer customer, double orderValue) {
		super();
		this.customer = customer;
		this.orderValue = orderValue;
	}
	

	public Orders(Long orderId, Customer customer, double orderValue, List<Items> orderItems) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderValue = orderValue;
		this.orderItems = orderItems;
		
	}
	
	public Orders(Long orderId, Customer customer, double orderValue) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderValue = orderValue;
		
		
	}

	
	public Orders(Long orderId,Customer customer) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		
	}


	public Long getId() {
		return orderId;
	}

	public void setId(Long id) {
		this.orderId = id;
	}

	

	public double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Items> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<Items> orderItems) {
		this.orderItems = orderItems;
	}


	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customer=" + customer + ", orderValue=" + orderValue + ", orderItems="
				+ orderItems + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderItems == null) ? 0 : orderItems.hashCode());
		long temp;
		temp = Double.doubleToLongBits(orderValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderItems == null) {
			if (other.orderItems != null)
				return false;
		} else if (!orderItems.equals(other.orderItems))
			return false;
		if (Double.doubleToLongBits(orderValue) != Double.doubleToLongBits(other.orderValue))
			return false;
		return true;
	}


}
