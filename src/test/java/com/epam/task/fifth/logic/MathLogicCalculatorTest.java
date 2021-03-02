package com.epam.task.fifth.logic;

import org.junit.Assert;
import org.junit.Test;

public class MathLogicCalculatorTest {

    @Test
    public void testCalculate() {
        //given
        String expression = "10 4 + 6 * 1 -";
        MathLogicCalculator calculator = new MathLogicCalculator(expression);

        int expected = -83;

        //when
        int actual = Integer.parseInt(calculator.calculate());

        //then
        Assert.assertEquals(expected, actual);
    }
}