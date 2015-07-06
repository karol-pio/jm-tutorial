package com.acme.calc;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator = new Calculator();;

	@Test
	public void additionShouldReturnCorrectResult() {
		// given
		double firstNumber = 5.0;
		double secondNumber = 6.0;
		// when w osobnej metodzie
		Double result = calculator.add(firstNumber, secondNumber);
		// then w osobnej metodzie
		Assert.assertTrue(result == 11);
	}

	@Test
	public void subtractionShouldReturnCorrectResult() {
		double firstNumber = 5.0;
		double secondNumber = 6.0;
		// when w osobnej metodzie
		Double result = calculator.subtract(firstNumber, secondNumber);
		// then w osobnej metodzie
		Assert.assertTrue(result == -1);
	}

	@Test
	public void multiplicationShouldReturnCorrectResult() {
		double firstNumber = 5.0;
		double secondNumber = 6.0;
		// when w osobnej metodzie
		Double result = calculator.multiply(firstNumber, secondNumber);
		// then w osobnej metodzie
		Assert.assertTrue(result == 30);
	}
	
	@Test
	public void divideShouldReturnCorrectResult() {
		double firstNumber = 5.0;
		double secondNumber = 1.0;
		// when w osobnej metodzie
		Double result = calculator.divide(firstNumber, secondNumber);
		// then w osobnej metodzie
		Assert.assertTrue(result == 5);
		
	}

}
