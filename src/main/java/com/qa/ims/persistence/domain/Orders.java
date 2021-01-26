package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	
	private Long id;
	private Customer customer;
	private double orderPrice;
	private List<Items> items = new ArrayList<>();
	
	public Orders(Long id, Customer customer, double orderPrice, List<Items> items) {
		super();
		this.id = id;
		this.customer = customer;
		this.orderPrice = orderPrice;
		this.items = items;
		
	}
	
	public Orders(Long id, Customer customer, double orderPrice) {
		super();
		this.id = id;
		this.customer = customer;
		this.orderPrice = orderPrice;
		
	}
	
	public Orders( Customer customer, double orderPrice) {
		super();
		this.customer = customer;
		this.orderPrice = orderPrice;
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", customer=" + customer + ", orderPrice=" + orderPrice + ", items=" + items + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		long temp;
		temp = Double.doubleToLongBits(orderPrice);
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (Double.doubleToLongBits(orderPrice) != Double.doubleToLongBits(other.orderPrice))
			return false;
		return true;
	}
	
	
	
	
	

}
