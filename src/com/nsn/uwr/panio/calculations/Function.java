package com.nsn.uwr.panio.calculations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.nsn.uwr.panio.inputsparser.EOperand;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Function {
	String value();
}
