package br.com.udemy.math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {

    SimpleMath math;

    @BeforeAll
    static void setup() {
        System.out.println("Running @BeforeAll method!");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Running @AfterAll method!");
    }

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method!");
    }

    @AfterEach
    void AfterEachMethod() {
        System.out.println("Running @AfterEach method!");
    }

    @ParameterizedTest
    @CsvSource({"6.2,2,8.2"})
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testShouldReturnSumOfTwoValues(double firstNumber, double secondNumber, double expected) {
        var message = format("%1$,.1f + %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);
        var actual = math.sum(firstNumber, secondNumber);
        assertEquals(expected, actual, () -> message);
    }

    @ParameterizedTest
    @CsvSource({"6.2,2,4.2"})
    @DisplayName("Test 6.2 - 2 = 4.2")
    void testShouldReturnSubtractionOfTwoValues(double firstNumber, double secondNumber, double expected) {
        var message = format("%1$,.1f - %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);
        var actual = math.subtraction(firstNumber, secondNumber);
        assertEquals(expected, actual, () -> message);
    }

    @ParameterizedTest
    @CsvSource({"6.2,2,12.4"})
    @DisplayName("Test 6.2 * 2 = 12.4")
    void testShouldReturnMultiplicationOfTwoValues(double firstNumber, double secondNumber, double expected) {
        var message = format("%1$,.1f * %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);
        var actual = math.multiplication(firstNumber, secondNumber);
        assertEquals(expected, actual, () -> message);
    }

    @ParameterizedTest
    @CsvSource({"6.2,2,3.1"})
    @DisplayName("Test 6.2 / 2 = 3.1")
    void testShouldReturnDivisionOfTwoValues(double firstNumber, double secondNumber, double expected) {
        var message = format("%1$,.1f / %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);
        var actual = math.division(firstNumber, secondNumber);
        assertEquals(expected, actual, () -> message);
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("Test (6.2D + 2) / 2 = 4.1")
    void testShouldReturnTheMedianValueOfNumber(double firstNumber, double secondNumber, double expected) {
        var message = format("(%1$,.1f + %2$,.1f) / 2 did not produce %3$,.1f", firstNumber, secondNumber, expected);
        var actual = math.mean(firstNumber, secondNumber);
        assertEquals(expected, actual, () -> message);
    }

    @ParameterizedTest
    @MethodSource("testSquareRootInputParams")
    @DisplayName("Test Square Root of 6.2 = 2.48")
    void testShouldReturnTheSquareRootOfNumber(double number, double expected) {
        var message = format("Square root of %1$,.1f did not produce %2$,.1f", number, expected);
        var actual = math.squareRoot(number);
        assertEquals(expected, actual, 2D, () -> message);
    }

    @Test
    @Disabled
    @DisplayName("Test Division by Zero")
    void testDivisionByZero() {
        var firstNumber = 6.2D;
        var secondNumber = 0D;
        var expectedMessage = "Impossible to divise by zero!";

        var actual = assertThrows(ArithmeticException.class,
                () -> math.division(firstNumber, secondNumber),
                () -> "Division by zero should throw an ArithmeticException");

        assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected Arithmetic Exception");
    }

    private static Stream<Arguments> testShouldReturnTheMedianValueOfNumber() {
        return Stream.of(
                Arguments.of(6.2D, 2D, 4.1)
        );
    }

    private static Stream<Arguments> testSquareRootInputParams() {
        return Stream.of(
                Arguments.of(6.2D, 2.48D)
        );
    }

}
