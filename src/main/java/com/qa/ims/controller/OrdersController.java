package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.JavaUtilities;

public class OrdersController  implements ICrudController<Orders>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrdersDao ordersdao;
	private JavaUtilities javaUtilities;
	
	public OrdersController(OrdersDao ordersdao, JavaUtilities javaUtilities) {
		super();
		this.ordersdao = ordersdao;
        this.javaUtilities = javaUtilities;
	}
	
	

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersdao.readAll();
        for (Orders order : orders) {
            LOGGER.info(order);
        }
        return orders;
		
	}

	@Override
	public Orders create() {
		LOGGER.info("To create an order please enter the customer id");
		Long customerID = javaUtilities.getLong();
		Orders orders = ordersdao.create(new Orders ((new Customer(customerID,null,null)),0.0));
		LOGGER.info("Order created");
		return orders;
	}
	

	@Override
	public Orders update() {
		Orders orderValue = null;
		LOGGER.info("Please Input an order id to update");
		Long orderID = javaUtilities.getLong();
		LOGGER.info("Would you like to add or remove an item?");
		String operation = javaUtilities.getString();
		switch (operation) {
		case "add":
			LOGGER.info("Input the item id for the item to be added");
			Long itemID = javaUtilities.getLong();
			orderValue = ordersdao.addItems(orderID, itemID);
			ordersdao.update(orderValue);
			LOGGER.info("Order Updated");
			break;
		case "remove": 
			LOGGER.info(" Input the item id for the item to be removed");
			Long itemID1 = javaUtilities.getLong();
			orderValue = ordersdao.removeItem(orderID, itemID1);
			ordersdao.update(orderValue);
			LOGGER.info("Order Updated");
			break;
		default:
			LOGGER.info("Invalid Operation");
			break;
		}
		return orderValue;
		
	}

	@Override
	public int delete() {
		 LOGGER.info("Please enter the id of the order you would like to delete");
	        Long id = javaUtilities.getLong();
	        return ordersdao.delete(id);
	    }
	
}
