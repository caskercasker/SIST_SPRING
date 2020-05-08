package com.sist.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class CalculatorTest {
	@Test
	public void testSum(){
		Calculator c = new Calculator();
		double result = c.sum(10, 50);
		assertEquals(60, result,0);
	}
}
