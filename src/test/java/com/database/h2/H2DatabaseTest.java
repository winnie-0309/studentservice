package com.database.h2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class H2DatabaseTest {
	ConnectionPool pool;
	@Before
	public void setup() {
		pool =  ConnectionPool.getInstance();
		
	}
	
	
	@Test
	public void testConnection() throws SQLException {
		Connection connection = pool.getConnection();
		Assert.assertNotNull(connection);
		Set<Entry<Object, Object>> entrySet = connection.getClientInfo().entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey()+ " =  " + entry.getValue());
		}
		
	}
	
	@Test
	public void testCRUD() throws SQLException {
		//create table
		CommonDao.crateTable();
		//
		long lastModifyTime = (new Date()).getTime();
		CommonDao.addInfo("ABC", lastModifyTime, "OK");
		//
		boolean infoExits = CommonDao.isInfoExits("ABC", lastModifyTime);
		Assert.assertTrue(infoExits);
	}

}
