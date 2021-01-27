package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	
	private Long id;
	private Long fk_customerId;
	private double orderPrice;
	private List<Items> items = new ArrayList<>();
	
	public Orders(Long id, Long fk_customerId, double orderPrice, List<Items> items) {
		super();
		this.id = id;
		this.setFk_customerId(fk_customerId);
		this.orderPrice = orderPrice;
		this.items = items;
		
	}
	
	public Orders(Long id,Long fk_customerId, double orderPrice) {
		super();
		this.id = id;
		this.setFk_customerId(fk_customerId);
		this.orderPrice = orderPrice;
		
	}
	
	public Orders( Long fk_customerId, double orderPrice) {
		super();
		this.setFk_customerId(fk_customerId);
		this.orderPrice = orderPrice;
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getFk_customerId() {
		return fk_customerId;
	}

	public void setFk_customerId(Long fk_customerId) {
		this.fk_customerId = fk_customerId;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", fk_customerId=" + fk_customerId + ", orderPrice=" + orderPrice + ", items="
				+ items + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fk_customerId == null) ? 0 : fk_customerId.hashCode());
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
		if (fk_customerId == null) {
			if (other.fk_customerId != null)
				return false;
		} else if (!fk_customerId.equals(other.fk_customerId))
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
