package com.nsn.uwr.panio;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DummyClassTest {

	private DummyClass dummyClass;
	private static int counterBeforeClass;
	private static int counterBefore;

	@Before
	public void setUp() {
		dummyClass = new DummyClass();
		counterBefore++;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() {
		counterBeforeClass++;
	}
	
	@AfterClass
	public static void setUpAfterClass() {
		System.err.println("counterBefore " + counterBefore + " counterBeforeClass " + counterBeforeClass);
	}

	@Test
	public void testDummyOperation() {
		//given
		int x = 2, y=3;
		
		//when
		int result = dummyClass.dummyOperation(x, y);
		
		//then
		Assert.assertEquals(5, result);
	}
	
	@Test
	public void testBeforeClass() {
		//given
		int x = 2, y=3;
		
		//when
		int result = dummyClass.dummyOperation(x, y);
		
		//then
		Assert.assertEquals(5, result);
	}
}
