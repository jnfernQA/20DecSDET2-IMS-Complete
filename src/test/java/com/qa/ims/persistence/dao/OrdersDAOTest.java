//package com.qa.ims.persistence.dao;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.qa.ims.persistence.domain.Customer;
//import com.qa.ims.persistence.domain.Items;
//import com.qa.ims.persistence.domain.Orders;
//import com.qa.ims.utils.DatabaseUtilities;
//
//public class OrdersDAOTest {
//	
//private final OrdersDao ODAO = new OrdersDao(new ItemsDao(),new CustomerDao());
//
//	
//	@Before
//    public void setup() {
//        DatabaseUtilities.connect();
//        DatabaseUtilities.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
//        List<Items> itemList = new ArrayList<>();
//        itemList.add(new Items(1L, "PS5", 449.99));
//        itemList.add(new Items(2L,"XBox", 360.00));
//        Orders testOrder =new Orders(1L, new Customer(1L,"jordan","harrsion"), 809.99,itemList);
//        
//        
//    }
//	
//	@Test
//    public void testCreate() {
//        final Orders created = new Orders(2L, new Customer(1L,"jordan","harrison"),809.99);
//        assertEquals(created, ODAO.create(created));
//    }
//
//    @Test
//    public void testReadAll() {
//        List<Orders> expected = new ArrayList<>();
//        expected.add(new Orders(1L, new Customer(1L,"jordan","harrison"),809.99));
//        assertEquals(expected, ODAO.readAll());
//    }
//
////    @Test
////    public void testReadLatest() {
////        assertEquals(new Items(1L, "PS5", 449.99), Dao.readLatest());
////    }
//
////    @Test
////    public void testRead() {
////        final long ID = 1L;
////        assertEquals(new Items(ID, "PS5", 449.99), Dao.readItems(ID));
////    }
//
////    @Test
////    public void testUpdate() {
////        final Items updated = new Items(1L, "Xbox", 360.00);
////        assertEquals(updated, Dao.update(updated));
////
////    }
//
////    @Test
////    public void testDelete() {
////        assertEquals(1, Dao.delete(1));
////    }
////	
//
//}
