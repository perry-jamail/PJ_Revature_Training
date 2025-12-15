package com.revature.demo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    Calculator calculator = null;

    @ParameterizedTest(name = "Positive Add {0} + {1} = {2}")
    @CsvFileSource(resources = "/testAddP.csv", numLinesToSkip = 1)
    @DisplayName("Testing Add Methods... Positive")
    //@Order(1)
    void testAdd(int a, int b, int expectedResult) {
        Assertions.assertEquals(expectedResult, calculator.add(a, b));
    }

    @ParameterizedTest(name = "Negative Add {0} + {1} = {2}")
    @CsvFileSource(resources = "/testAddN.csv", numLinesToSkip = 1)
    @DisplayName("Testing Add Methods... Negative")
    void testAddNegative(int a, int b, int expectedResult) {
        Assertions.assertEquals(expectedResult, calculator.add(a, b));
    }

    @ParameterizedTest(name = "Positive Subtract {0} - {1} = {2}")
    @CsvFileSource(resources = "/testSubtractP.csv", numLinesToSkip = 1)
    @DisplayName("Testing Subtract Methods... Positive")
    public void testSubtractPositive(int a, int b, int expectedResult) {
        Assertions.assertEquals(expectedResult, calculator.subtract(a, b));
    }

    @ParameterizedTest(name = "Negative Subtract {0} - {1} = {2}")
    @CsvFileSource(resources = "/testSubtractN.csv", numLinesToSkip = 1)
    @DisplayName("Testing Subtract Methods... Negative")
    public void testSubtractNegative(int a, int b, int expectedResult) {
        Assertions.assertEquals(expectedResult, calculator.subtract(a, b));
    }

    @ParameterizedTest(name = "Positive Multiply {0} * {1} = {2}")
    @CsvFileSource(resources = "/testMultiplyP.csv", numLinesToSkip = 1)
    @DisplayName("Testing Multiply Methods... Positive")
    public void testMultiplyPositive(int a, int b, int expectedResult) {
        Assertions.assertEquals(expectedResult, calculator.multiply(a, b));
    }

    @ParameterizedTest(name = "Negative Multiply {0} * {1} = {2}")
    @CsvFileSource(resources = "/testMultiplyN.csv", numLinesToSkip = 1)
    @DisplayName("Testing Multiply Methods... Negative")
    public void testMultiplyNegative(int a, int b, int expectedResult) {
        Assertions.assertEquals(expectedResult, calculator.multiply(a, b));
    }

    @ParameterizedTest(name = "Positive Divide {0} / {1} = {2}")
    @CsvFileSource(resources = "/testDivideP.csv", numLinesToSkip = 1)
    @DisplayName("Testing Divide Methods... Positive")
    public void testDividePositive(double a, double b, double expectedResult) {
        Assertions.assertEquals(expectedResult, calculator.divide(a, b));
    }

    @ParameterizedTest(name = "Negative Divide {0} / {1} = {2}")
    @CsvFileSource(resources = "/testDivideN.csv", numLinesToSkip = 1)
    @DisplayName("Testing Divide Methods... Negative")
    public void testDivideNegative(double a, double b, double expectedResult) {
        Assertions.assertEquals(expectedResult, calculator.divide(a, b));
    }

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("This is the Setup method .... BeforeEach");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("This is the Tear Down method .... AfterEach");
    }

    @BeforeAll
    public static void setupClass() {
        System.out.println("Before All method is called...");
    }

    @AfterAll
    public static void teardownClass() {
        System.out.println("After All is called...");
    }
}
