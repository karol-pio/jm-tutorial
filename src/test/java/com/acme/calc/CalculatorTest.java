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

		// then
		Assert.assertFalse(result.isNaN());

		Assert.assertTrue(result == 11);
	}

	private double firstNumber;
	private double secondNumber;
	private Exception thrown;

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


	public void divisionShouldThrowExceptionWhenDivisorIsZero() {
		givenNumbersWithZero();
		catchException(() -> calculator.divide(firstNumber,secondNumber));
		assertException(DivisorCannotBeZeroException.class);
	}

	private void catchException(Runnable runnable) {
		try {
			runnable.run();
		} catch (Exception e) {
			thrown = e;
		}
	}

	private void assertException(Class<DivisorCannotBeZeroException> expectedExceptionClass) {
		Assert.assertNotNull(thrown);
		Assert.assertTrue(expectedExceptionClass.equals(thrown.getClass()));
	}
	private void assertThat(Exception e, Class<?> expectedClass) {
		Assert.assertTrue(e.getClass().equals(expectedClass));
	}
	private void thenCorrectExceptionIsThrons(Exception e) {
		Assert.assertTrue(e.getClass().equals(
				DivisorCannotBeZeroException.class));
	}
	// TODO division and multiplication test!
	private void givenNumbersWithZero() {
		firstNumber = 5.0;
		secondNumber = 0.0;
	}

}
