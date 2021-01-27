package com.qa.ims.persistence.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DatabaseUtilities;

public class OrdersDao implements IDomainDao<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	public Orders create(Orders orders) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(id, cust_id) VALUES (?, ?)");){
			statement.setLong(1, orders.getFk_customerId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
	        LOGGER.error(e.getMessage());
	        
		}
		return null;
			
		}
	
	public Orders addItems(Long fkOrderId, Long fkItemId ) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement =connection
						.prepareStatement("INSERT INTO orderItems(order_id, item_id) VALUES(?,?)");){
			statement.setLong(1, fkOrderId);
			statement.setLong(2, fkItemId);
			statement.executeUpdate();
			return readLatest();
		}catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		calculateOrderValue();
		
		return null;
		
		
	}
	
	public Orders calculateOrderValue() {
		return null;
		
	}
		

	private Orders readLatest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders update(Orders t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
