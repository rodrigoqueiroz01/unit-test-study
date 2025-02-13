package br.com.udemy.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTestS4 {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Pelé", "Senna", "Rodrigo"})
    void testValueSource(String firstName) {
        assertNotNull(firstName);
    }

/*
    @MethodSource("testDivisionInputParameters")
    @MethodSource
    @CsvSource({
            "Pelé, Futebol",
            "Senna, F1",
            "Keith Moon, ''"
    })
    @CsvSource({
            "6.2, 2, 3.1",
            "71, 14, 5.07",
            "18.3, 3.1, 5.90"
    })
*/
    @CsvFileSource(resources = "/testDivisions.csv")
    @ParameterizedTest
    @DisplayName("Test double sbtraction [firstNumber, secondNumber, expectedResult]")
    void testDivision(double firstNumber, double secondNumber, double expectedResult) {
        System.out.printf("Test: %1$,.1f / %2$,.1f = %3$,.1f%n\n", firstNumber, secondNumber, expectedResult);

        var message = format("%1$,.1f / %2$,.1f did not produce %3$,.1f", firstNumber, secondNumber, expectedResult);
        var actual = math.division(firstNumber, secondNumber);
        assertEquals(expectedResult, actual, 2D, () -> message);
    }

    /*
    public static Stream<Arguments> testDivisionInputParameters() {
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(71, 14D, 5.07D),
                Arguments.of(18.3, 3.1D, 5.90D)
        );
    }
    */

    /*
    public static Stream<Arguments> testDivision() {
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(71, 14D, 5.07D),
                Arguments.of(18.3, 3.1D, 5.90D)
        );
    }
    */

}
