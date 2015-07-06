package com.acme.calc;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator = new Calculator();
	

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
		Assert.assertFalse(result.isNaN());
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

//	@Test(expected=Divisio
	@Test
	public void divideShouldReturnCorrectResult() {
		double firstNumber = 5.0;
		double secondNumber = 0.0;
		//when w osobnej metodzie
 
		
		try {
		Double result = calculator.divide(firstNumber, secondNumber);
		}
		catch (Exception e){
			Assert.assertTrue(e.getClass().equals(DivisorCannotBeZeroException.class));
			
		}
		// then w osobnej metodzie
		
	
		
//	   Assert.assertThat("failure - can't divide by 0",secondNumber, is(not(0.0)));
//	   Assert.assertTrue("failure - not equal", Math.divide(firstNumber, secondNumber) == 1.5);
		
	}


}
