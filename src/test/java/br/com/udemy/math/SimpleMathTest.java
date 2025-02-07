package br.com.udemy.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {

    // Padrão de nomenclatura dos métodos de teste: test[SystemUnderTest][ConditionOrStateChange][ExpectedResult]

    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testShouldReturnSumOfTwoValues() {
        var math = new SimpleMath();
        var firstNumber = 6.2D;
        var secondNumber = 2D;

        var expected = 8.2D;
        var actual = math.sum(6.2D, 2D);
        var messageSupplier = format("%1$,.1f + %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);

        assertEquals(expected, actual, () -> messageSupplier);
    }

    @Test
    @DisplayName("Test 6.2 - 2 = 4.2")
    void testShouldReturnSubtractionOfTwoValues() {
        var math = new SimpleMath();
        var firstNumber = 6.2D;
        var secondNumber = 2D;

        var expected = 4.2D;
        var actual = math.subtraction(firstNumber, secondNumber);
        var messageSupplier = format("%1$,.1f - %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);

        assertEquals(expected, actual, () -> messageSupplier);
    }

    @Test
    @DisplayName("Test 6.2 * 2 = 12.4")
    void testShouldReturnMultiplicationOfTwoValues() {
        var math = new SimpleMath();
        var firstNumber = 6.2D;
        var secondNumber = 2D;

        var expected = 12.4D;
        var actual = math.multiplication(firstNumber, secondNumber);
        var messageSupplier = format("%1$,.1f * %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);

        assertEquals(expected, actual, () -> messageSupplier);
    }

    @Test
    @DisplayName("Test 6.2 / 2 = 3.1")
    void testShouldReturnDivisionOfTwoValues() {
        var math = new SimpleMath();
        var firstNumber = 6.2D;
        var secondNumber = 2D;

        var expected = 3.1D;
        var actual = math.division(firstNumber, secondNumber);
        var messageSupplier = format("%1$,.1f / %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);

        assertEquals(expected, actual, () -> messageSupplier);
    }

    @Test
    @DisplayName("Test (6.2D + 2) / 2 = 4.1")
    void testShouldReturnTheMedianValueOfNumber() {
        var math = new SimpleMath();
        var firstNumber = 6.2D;
        var secondNumber = 2D;

        var expected = 4.1D;
        var actual = math.mean(firstNumber, secondNumber);
        var messageSupplier = format("(%1$,.1f + %2$,.1f) / 2 did not produce %3$,.1f", firstNumber, secondNumber, expected);

        assertEquals(expected, actual, () -> messageSupplier);
    }

    @Test
    @DisplayName("Test Square Root of 6.2 = 2.4899799195977463D")
    void testShouldReturnTheSquareRootOfNumber() {
        var math = new SimpleMath();
        var number = 6.2D;

        var expected = 2.4899799195977463D;
        var actual = math.squareRoot(number);
        var messageSupplier = format("Square root of %1$,.1f did not produce %2$,.1f", number, expected);

        assertEquals(expected, actual, () -> messageSupplier);
    }

}
