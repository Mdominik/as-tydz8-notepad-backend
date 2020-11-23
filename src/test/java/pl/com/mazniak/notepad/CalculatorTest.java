package pl.com.mazniak.notepad;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void should_add_two_numbers() {
        //given
        Calculator calculator = new Calculator();

        //then
        Assert.assertEquals(calculator.add(10, 15), 25);
        Assert.assertEquals(calculator.add(-10, 10), 0);
    }

    @Test
    public void should_not_add_two_numbers() {
        //given
        Calculator calculator = new Calculator();

        //then
        Assert.assertNotEquals(calculator.add(10, 20), 25);
        Assert.assertNotEquals(calculator.add(0, 10), 0);
    }

    @Test
    public void should_divide_two_numbers() {
        //given
        Calculator calculator = new Calculator();

        //then
        Assert.assertEquals(0.5, calculator.divide(10, 20), 0.001);
        Assert.assertEquals(0.0, calculator.divide(0, 10), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void should_not_divide_by_zero() {
        //given
        Calculator calculator = new Calculator();

        //then
        Assert.assertNotEquals(0.0, calculator.divide(10, 20), 0.001);
    }
}
