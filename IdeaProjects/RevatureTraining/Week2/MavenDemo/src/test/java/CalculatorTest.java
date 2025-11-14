import com.revature.mavendemo.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void calculatorTest() {
        Calculator calc = new Calculator();
        int x = 10;
        int y = 20;
        int result = x + y;

        Assertions.assertEquals(result, calc.add(x, y));
    }
}
