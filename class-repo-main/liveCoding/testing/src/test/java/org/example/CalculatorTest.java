package org.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    @Parameters({"10,5,15", "0,7,7", "2,3,5"})
    public void sumTest(int num1, int num2, int expected) {

        assertEquals(expected, calculator.add(num1, num2));
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"10,-10", "-5,5", "-2,-2"})
    public void sumNegativeTest(int num1, int num2) {
        calculator.add(num1, num2);
    }
}
