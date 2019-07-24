package com.bit.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bit.model.entity.Bbs02Vo;

public class Bbs02DaoTest {
	Bbs02Dao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws SQLException{
//		dao = new Bbs02Dao();
	}
	
	@AfterClass
	public static void tearDownAfterClass(){
	}
	
	@Before
	public void setUp() throws SQLException{
		dao = new Bbs02Dao();
	}
	
	@After
	public void tearDown(){
	}
	
	@Test
	public void testInsertOne() throws SQLException{
		Bbs02Vo bean=new Bbs02Vo();
		bean.setName("tester");
		bean.setSub("testData");
		bean.setContent("test");
		Bbs02Dao dao =new Bbs02Dao();
		assertSame(1, dao.insertOne(bean));
	}	
	
	@Test
	public void testSelectAll() throws SQLException{
		assertNotNull(dao.selectAll("test01"));
		assertTrue(dao.selectAll("%%").size()>0);
//		assertSame(1, dao.selectAll("test01").size());
	}
	
		
//		Assert.assertNull(dao);	// 널이면 성공
//		Assert.assertEquals(1, 1);	// 같으면 성공
//		Assert.assertSame(1, 1);	// 같으면 성공
//		Assert.assertNotSame(1, 2);	// 같지 않으면 성공
//		Assert.assertTrue(true);	// true이면 성공
//		Assert.assertFalse(false);	// false이면 성공
}























