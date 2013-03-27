package com.nsn.uwr.panio.calculations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.nsn.uwr.panio.inputsparser.EOperand;
import com.nsn.uwr.panio.inputsparser.FunctionInput;

public class AlgebraicCalculations {

	@Function(EOperand.ADD)
	public double add(double arg1, double arg2) {
		return arg1 + arg2;
	}

	@Function(EOperand.SUBTRACT)
	public double subtract(double arg1, double arg2) {
		return arg1 - arg2;
	}
	
	@Function(EOperand.MULTIPLY)
	public double multiply(double arg1, double arg2) {
		return arg1 * arg2;
	}
	
	@Function(EOperand.DIVIDE)
	public double divide(double arg1, double arg2) {
		return arg1 / arg2;
	}

	public double invoke(FunctionInput input) {

		Method method = findSuitableMethod(input);
		try {
			return (double) method.invoke(this, input.getArg1(),
					input.getArg2());
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		

	}

	private Method findSuitableMethod(FunctionInput input) {
		
		for (Method method : this.getClass().getMethods()) {
			Function annotation = method.getAnnotation(Function.class);
			if (annotation != null && annotation.value() == input.getOperand()) {
				try {
					return method;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}
		throw new NotImplementedException();
	}

}
