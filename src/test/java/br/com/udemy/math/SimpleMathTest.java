package br.com.udemy.math;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {

    // Padrão de nomenclatura dos métodos de teste: test[SistemaEmTeste][CondicaoOuMudancaDeEstado][ResultadoEsperado]

    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testShouldReturnSumOfTwoValues() {
        var firstNumber = 6.2D;
        var secondNumber = 2D;
        var expected = 8.2D;
        var message = format("%1$,.1f + %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);

        // Given / Arrange - dado um determinado contexto (tem-se determinada reação)
        var math = new SimpleMath();

        // When / Act - quando ocorrer a ação
        var actual = math.sum(firstNumber, secondNumber);

        // Then / Assert - valida o retorno esperado
        assertEquals(expected, actual, () -> message);
    }

    @Test
    @DisplayName("Test 6.2 - 2 = 4.2")
    void testShouldReturnSubtractionOfTwoValues() {
        var firstNumber = 6.2D;
        var secondNumber = 2D;
        var expected = 4.2D;
        var message = format("%1$,.1f - %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);

        var math = new SimpleMath();
        var actual = math.subtraction(firstNumber, secondNumber);
        assertEquals(expected, actual, () -> message);
    }

    @Test
    @DisplayName("Test 6.2 * 2 = 12.4")
    void testShouldReturnMultiplicationOfTwoValues() {
        var firstNumber = 6.2D;
        var secondNumber = 2D;
        var expected = 12.4D;
        var message = format("%1$,.1f * %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);

        var math = new SimpleMath();
        var actual = math.multiplication(firstNumber, secondNumber);
        assertEquals(expected, actual, () -> message);
    }

    @Test
    @DisplayName("Test 6.2 / 2 = 3.1")
    void testShouldReturnDivisionOfTwoValues() {
        var firstNumber = 6.2D;
        var secondNumber = 2D;
        var expected = 3.1D;
        var message = format("%1$,.1f / %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expected);

        var math = new SimpleMath();
        var actual = math.division(firstNumber, secondNumber);
        assertEquals(expected, actual, () -> message);
    }

    @Test
    @DisplayName("Test (6.2D + 2) / 2 = 4.1")
    void testShouldReturnTheMedianValueOfNumber() {
        var firstNumber = 6.2D;
        var secondNumber = 2D;
        var expected = 4.1D;
        var message = format("(%1$,.1f + %2$,.1f) / 2 did not produce %3$,.1f", firstNumber, secondNumber, expected);

        var math = new SimpleMath();
        var actual = math.mean(firstNumber, secondNumber);
        assertEquals(expected, actual, () -> message);
    }

    @Test
    @DisplayName("Test Square Root of 6.2 = 2.4899799195977463D")
    void testShouldReturnTheSquareRootOfNumber() {
        var number = 6.2D;
        var expected = 2.4899799195977463D;
        var message = format("Square root of %1$,.1f did not produce %2$,.1f", number, expected);

        var math = new SimpleMath();
        var actual = math.squareRoot(number);
        assertEquals(expected, actual, () -> message);
    }

    @Disabled("TODO We need still work on it!")
    @Test
    @DisplayName("Test Division by Zero")
    void testDivisionByZero() {
        fail();
    }

}
