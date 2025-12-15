import pytest

@pytest.mark.parametrize("n1, n2,expectedResult",[
    (1, 2, 3),
    (3, 2, 5),
    (6, 8, 14)
])
def test_add_params(n1, n2, expectedResult):
    assert n1 + n2 == expectedResult