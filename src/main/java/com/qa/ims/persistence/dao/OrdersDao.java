package com.qa.ims.persistence.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DatabaseUtilities;

public class OrdersDao implements IDomainDao<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemsDao itemsDao;
	private CustomerDao customerDao;
	
	public OrdersDao (ItemsDao itemsDao, CustomerDao customerDao) {
		super();
		this.itemsDao = itemsDao;
		this.customerDao = customerDao;
	}
	
	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Customer cust = customerDao.read(resultSet.getLong("cust_id"));
		double value = calculateOrderValue(id);
		List<Items> items = getItems(id);
		return new Orders(id, cust, value, items);
		
	}
	
	private List<Items> getItems(Long orderId) {
		List<Long> itemid = new ArrayList<>();
		
		try(Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM orderItems where order_id = ?");){
			statement.setLong(1, orderId);
			try(ResultSet resultSet = statement.executeQuery();){
				while(resultSet.next()) {
					itemid.add(resultSet.getLong("item_id"));
				}
			}
		}catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
		return itemid.stream().map(this.itemsDao::readItems).collect(Collectors.toList());
		
	}
	
	@Override
	public List<Orders> readAll() {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
            List<Orders> orders = new ArrayList<>();
            while (resultSet.next()) {
                orders.add(modelFromResultSet(resultSet));
            }
            return orders;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
	}
	
	private Orders readLatest() {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
	}
	
	@Override
	public Orders create(Orders orders) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(cust_id) VALUES (?)");){
			statement.setLong(1, orders.getCustomer().getId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
	        LOGGER.error(e.getMessage());
	        
		}
		return null;
			
	}
	
	public Orders readOrders(Long id) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
	}
	
	@Override
	public Orders update(Orders orders) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("UPDATE orders SET value = ? WHERE id = ?");) {
            statement.setDouble(1, orders.getOrderValue());
            statement.setLong(2, orders.getId());
            statement.executeUpdate();
            return readOrders(orders.getId());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
		return null;
	}
	
	@Override
	public int delete(long id) {
		 try (Connection connection = DatabaseUtilities.getInstance().getConnection();
	                Statement statement = connection.createStatement();) {
	            return statement.executeUpdate("delete from orders where id = " + id);
	        } catch (Exception e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
		return 0;
	}
	
	public double calculateOrderValue(Long orderId) {
		double value = this.getItems(orderId).stream().map(item -> item.getItem_price()).reduce((acc, next) -> acc + next)
				.orElse(0.0);
		this.update(new Orders(orderId,null,value));
		return value;
	}


	
	public Orders addItems(Long orderId, Long itemId ) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement =connection
						.prepareStatement("INSERT INTO orderitems(order_id, item_id) VALUES(?,?)");){
			statement.setLong(1, orderId);
			statement.setLong(2, itemId);
			statement.executeUpdate();
			return readLatest();
		}catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		calculateOrderValue(orderId);
		return readOrders(orderId);
		
		
	}
	
	public Orders removeItem(Long orderId, Long itemId) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement =connection
						.prepareStatement("DELETE FROM orderItems where order_id = ? and item_id = ?");){
			statement.setLong(1, orderId);
			statement.setLong(2, itemId);
			statement.executeUpdate();
			return readLatest();
		}catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		calculateOrderValue(orderId);
		return readOrders(orderId);
		
	}
	
	
	
		
	
	
	
	
	

	
	
	

	


	
	



	
	
	

}
