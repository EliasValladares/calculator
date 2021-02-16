package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import evaluator.Evaluator;

@DisplayName("Evaluator Test")
public class EvaluatorTest {

	private Evaluator evaluator;
	
	@BeforeEach
	private void setUp() {
		evaluator = new Evaluator();
	}
	
	@Test
	 void addtest() {
		String in = "1+2";
		int expect = 3;
		int actual =  this.evaluator.eval(in);
		assertEquals(expect, actual);
	}
	
	@Test
	void subtractTest() {
		String in = "1-2";
		int expect = -1;
		int actual =  this.evaluator.eval(in);
		assertEquals(expect, actual);
	}
	
	@Test
	void multiplytTest() {
		String in = "2*2";
		int expect = 4;
		int actual =  this.evaluator.eval(in);
		assertEquals(expect, actual);
	}
	
	@Test
	void divideTest() {
		String in = "6/2";
		int expect = 3;
		int actual =  this.evaluator.eval(in);
		assertEquals(expect, actual);
	}
	
	@Test
	void powerTest() {
		String in = "2^3";
		int expect = 8;
		int actual =  this.evaluator.eval(in);
		assertEquals(expect, actual);
	}
	
	@Test
	void parensTest() {
		String in = "2+(2*2)-2";
		int expect = 4;
		int actual =  this.evaluator.eval(in);
		assertEquals(expect, actual);
	}
	
	@Test
	void multipleExpressionsTest() {
		String in = "(2^3) +(8/2) + 3^2 ";
		int expect = 21;
		int actual =  this.evaluator.eval(in);
		assertEquals(expect, actual);
	}
	
	@Test
	void multipleExpressionsTest2() {
		String in = "3^2/3 +(3+2) - 3^2 + (2^4) +(4+5)";
		int expect = 24;
		int actual =  this.evaluator.eval(in);
		assertEquals(expect, actual);
	}
	
	@Test
	void multipleExpressionsTest3() {
		String in = "(3^2/3 +(3+2)) + ((2-3)^2)*2 - 3^2 + (2^4) +(4+5)*(5-1-3*6)";
		int expect = -109;
		int actual =  this.evaluator.eval(in);
		assertEquals(expect, actual);
	}
	
	@Test
	void invalidInputTest() {
		String in = "2**3";
		assertThrows(EmptyStackException.class, () -> {
			this.evaluator.eval(in);
		});
	}
	
	
	

}
