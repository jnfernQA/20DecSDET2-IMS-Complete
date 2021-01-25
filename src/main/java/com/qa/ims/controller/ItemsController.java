package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.ItemsDao;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.JavaUtilities;

public class ItemsController implements ICrudController<Items>{
	
	public static final Logger LOGGER = LogManager.getLogger();

    private ItemsDao itemsDao;
    private JavaUtilities javaUtilities;
    
    public ItemsController(ItemsDao itemsDao, JavaUtilities javaUtilities) {
        super();
        this.itemsDao = itemsDao;
        this.javaUtilities = javaUtilities;
    }
    
    @Override
    public List<Items> readAll() {
        List<Items> items = itemsDao.readAll();
        for (Items item : items) {
            LOGGER.info(item);
        }
        return items;
    }
    
    @Override
    public Items create() {
        LOGGER.info("Please add the item's name");
        String item_name = javaUtilities.getString();
        LOGGER.info("Please enter the item's price in GBP");
        double item_price = javaUtilities.getDouble();
        Items items = itemsDao.create(new Items(item_name, item_price));
        LOGGER.info("Item added");
        return items;
    }
    
    @Override
    public Items update() {
        LOGGER.info("Please enter the id of the Item you would like to update");
        Long id = javaUtilities.getLong();
        LOGGER.info("Please enter the item name");
        String item_name = javaUtilities.getString();
        LOGGER.info("Please enter the item's price");
        double item_price = javaUtilities.getDouble();
        Items items = itemsDao.update(new Items(id, item_name, item_price));
        LOGGER.info("Item updates");
        return items;
    }
    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the item you would like to delete");
        Long id = javaUtilities.getLong();
        return itemsDao.delete(id);
    }

}