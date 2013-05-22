package com.nsn.uwr.panio.calculations.tree;

import org.fest.assertions.Assertions;
import org.junit.Test;



public class DivisionTest {
	@Test
	public void shouldDivide()
	{
		//given
		ConstantValueElement arg1 = new ConstantValueElement(10.0);
		ConstantValueElement arg2 = new ConstantValueElement(3.0);
		IValueElement arg3 = new Reciprocal(arg2);
		
		//when
		Division div = new Division(arg1, arg3);
		double res = div.getValue();
		
		//then
		Assertions.assertThat(res).isEqualTo(30.0);
		
	}
}
