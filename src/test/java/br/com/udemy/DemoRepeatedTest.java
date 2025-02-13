package br.com.udemy;

import br.com.udemy.math.SimpleMath;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.Random.class)
public class DemoRepeatedTest {

    SimpleMath math;

    @BeforeEach
    void beforeEacheMethod() {
        math = new SimpleMath();
    }

    @RepeatedTest(1)
    @DisplayName("Test Division by Zero")
    void testDivisionByZero(RepetitionInfo repetitionInfo, TestInfo testInfo) {
        var firstNumber = 6.2D;
        var secondNumber = 0D;

        var expectedMessage = "Impossible to divise by zero!";

        var actual = assertThrows(ArithmeticException.class, () -> math.division(firstNumber, secondNumber),
                () -> "Division by zero should throw an ArithmeticException");

        assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected Arithmetic Exception");
    }

}
