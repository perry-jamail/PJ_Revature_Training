import pytest

from src.com.revature.test_demo.Calculator import Calculator

@pytest.fixture
def calculator():
    return Calculator()

@pytest.mark.skip("Demonstrating the skip feature")
def test_add(calculator):
    result = calculator.add(1, 2)
    assert result == 3

def test_is_even(calculator):
    assert calculator.is_even(3) is False
    assert not calculator.is_even(5)

def test_divide_by_zero(calculator):
    with pytest.raises(ZeroDivisionError):
        calculator.divide(3, 0)

def test_divide_by_zero_context(calculator):
    with pytest.raises(ZeroDivisionError) as context:
        calculator.divide(3, 0)
        assert "zero" in str(context.value).lower()