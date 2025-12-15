import unittest

from src.com.revature.test_demo.Calculator import Calculator

class TestCalculator(unittest.TestCase):
    def setUp(self):
        self.calculator = Calculator()

    def test_add(self):
        n1 = 1
        n2 = 2
        expectedResult = 3

        result = self.calculator.add(n1, n2)
        self.assertEqual(result, expectedResult)

    @unittest.skip("Demonstrating the skip feature in unittest")
    def test_sub(self):
        n1 = 1
        n2 = 2
        expectedResult = -1
        result = self.calculator.subtract(n1, n2)
        self.assertEqual(result, expectedResult)

    def test_divide_by_zero(self):
        with self.assertRaises(ZeroDivisionError):
            self.calculator.divide(1, 0)

    def test_division_by_zero_context(self):
        with self.assertRaises(ZeroDivisionError) as context:
            self.calculator.divide(1, 0)

        self.assertEqual(str(context.exception), "Cannot divide by zero")

    def tearDown(self):
        self.calculator = None