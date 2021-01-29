package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DatabaseUtilities;


public class ItemsDAOTest {
	
	private final ItemsDao Dao = new ItemsDao();
	
	@Before
    public void setup() {
        DatabaseUtilities.connect();
        DatabaseUtilities.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
        
    }
	
	@Test
    public void testCreate() {
        final Items created = new Items(2L, "Xbox", 360);
        assertEquals(created, Dao.create(created));
    }

    @Test
    public void testReadAll() {
        List<Items> expected = new ArrayList<>();
        expected.add(new Items(1L, "PS5", 450));
        assertEquals(expected, Dao.readAll());
    }

    @Test
    public void testReadLatest() {
        assertEquals(new Items(1L, "PS5", 450), Dao.readLatest());
    }

    @Test
    public void testRead() {
        final long ID = 1L;
        assertEquals(new Items(ID, "PS5", 450), Dao.readItems(ID));
    }

    @Test
    public void testUpdate() {
        final Items updated = new Items(1L, "Xbox", 360);
        assertEquals(updated, Dao.update(updated));

    }

    @Test
    public void testDelete() {
        assertEquals(1, Dao.delete(1));
    }
	

}
