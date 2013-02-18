package com.nsn.uwr.panio;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class DummyClassTest {

	private DummyClass dummyClass;

	@Before
	public void setUp() {
		dummyClass = new DummyClass();
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
}
