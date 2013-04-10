package com.nsn.uwr.panio;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.nsn.uwr.panio.inputsparser.EOperand;


public class ArgumentsValidatorTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
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
	
	@Test
	public void shouldValidateArguments() {
		//given
		String[] args = {"2", "3", "+"};
		
		//when
		validatorUnderTest.validateArguments(args);
		
		//then
		//no exception
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionOnInvalidSecondArgument() {
		//given
		String[] args = {"2", "cv3", "+"};
		
		//when
		validatorUnderTest.validateArguments(args);
		
		//then
		//exception
	}
	
	@Test
	public void shouldThrowExceptionOnInvalidOperatorArgument() {
		//given
		String[] args = {"2", "3", "a"};
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("third argument should be operator");
		
		//when
		validatorUnderTest.validateArguments(args);
		
		//then
		// exception
	}
	
}
