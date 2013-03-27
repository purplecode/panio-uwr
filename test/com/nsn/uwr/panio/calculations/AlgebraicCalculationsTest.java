package com.nsn.uwr.panio.calculations;

import org.junit.Ignore;
import org.junit.Test;

import com.nsn.uwr.panio.inputsparser.EOperand;
import com.nsn.uwr.panio.inputsparser.FunctionInput;

import junit.framework.Assert;

public class AlgebraicCalculationsTest {

	private AlgebraicCalculations algebraicCalculations = new AlgebraicCalculations();

	@Test
	public void testShouldAdd2Doubles() {
		// given
		double x = 0.5, y = 0.6;
		FunctionInput functionInput = new FunctionInput(x, y, EOperand.ADD);

		// when
		double res = algebraicCalculations.invoke(functionInput);

		// then
		Assert.assertEquals(1.1, res);

	}

	@Test
	public void testShouldSubtract2Double() {
		// given
		double x = 2.5, y = 2.0;
		FunctionInput functionInput = new FunctionInput(x, y, EOperand.SUBTRACT);
		
		// when
		double res = algebraicCalculations.invoke(functionInput);

		// then
		Assert.assertEquals(0.5, res);

	}
	
	@Test
	public void testShouldMultiply2Double() {
		// given
		double x = 2.0, y = 2.0;
		FunctionInput functionInput = new FunctionInput(x, y, EOperand.MULTIPLY);
		
		// when
		double res = algebraicCalculations.invoke(functionInput);

		// then
		Assert.assertEquals(4, res);

	}
	
	@Test
	public void testShouldDivide2Double() {
		// given
		double x = 4.0, y = 2.0;
		FunctionInput functionInput = new FunctionInput(x, y, EOperand.DIVIDE);
		
		// when
		double res = algebraicCalculations.invoke(functionInput);

		// then
		Assert.assertEquals(2.0, res);

	}
}
