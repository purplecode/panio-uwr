package com.nsn.uwr.panio;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.nsn.uwr.panio.inputsparser.EOperand;


public class ArgumentsValidatorTest {
	
	private ArgumentsValidator validatorUnderTest;

	@Before
	public void init() {
		validatorUnderTest = new ArgumentsValidator();
	}
	
	@Test
	public void shouldValidateNumbersPositively() {
		//given
		String testString = "23.4";
		//when
		boolean validationResult = validatorUnderTest.isValidNumber(testString);
		//than
		Assertions.assertThat(validationResult).isTrue();
	}
	
	@Test
	public void shouldValidateNumbersNegatively() {
		//given
		String testString = "2.3.4";
		//when
		boolean validationResult = validatorUnderTest.isValidNumber(testString);
		//than
		Assertions.assertThat(validationResult).isFalse();
	}
	
	@Test
	public void shouldValidateOperatorsNegatively() {
		//given
		String testString = "==0";
		//when
		boolean validationResult = validatorUnderTest.isValidOperator(testString);
		//than
		Assertions.assertThat(validationResult).isFalse();
	}
	
	@Test
	public void shouldValidateOperatorsPositively() {
		//given
		EOperand[] operands = EOperand.values();		
		for (EOperand eOperand : operands) {
			//when
			boolean validationResult = validatorUnderTest.isValidOperator(eOperand.getOperand());
			//than
			Assertions.assertThat(validationResult).isTrue();
		}
		
	}
}
