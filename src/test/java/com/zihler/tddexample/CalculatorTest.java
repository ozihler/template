package com.zihler.tddexample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void test() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.add(""));
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("3,2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExc() {
        new Calculator().add("1,2,3");
        new Calculator().add("1,2,3,4");
    }

    private class Calculator {
        public int add(String numbers) {
            if (numbers.isBlank()) {
                return 0;
            }

            if (hasTooManyArguments(numbers)) {
                throw new IllegalArgumentException();
            }

            return calculateSum(numbers);
        }

        private int calculateSum(String numbers) {
            String[] splits = numbers.split(",");
            int sum = 0;
            for (String split : splits) {
                sum += Integer.parseInt(split);
            }
            return sum;
        }

        private boolean hasTooManyArguments(String numbers) {
            return numbers.split(",").length >= 3;
        }
    }
}
