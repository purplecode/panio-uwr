package com.nsn.uwr.panio.calculations;

import org.junit.Test;

import junit.framework.Assert;

public class AlgebraicCalculationsTest {

	private AlgebraicCalculations algebraicCalculations = new AlgebraicCalculations();

	@Test
	public void testShouldAdd2Doubles() {
		// given
		double x = 0.5, y = 0.6;

		// when
		double res = algebraicCalculations.add(x, y);

		// then
		Assert.assertEquals(1.1, res);

	}
}
