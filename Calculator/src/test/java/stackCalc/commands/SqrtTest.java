package stackCalc.commands;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import static org.junit.Assert.assertEquals;

public class SqrtTest {

    @Test
   public void execute() {
        Sqrt sqrt = new Sqrt();
        Map<String, Double> define = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        stack.push(0.25);
        String[] s = new String[0];
        Double expected = 0.5;
        try {
            sqrt.execute(define, stack, s);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expected, stack.pop());
    }

    @org.junit.jupiter.api.Test
    void testExecute() {
    }
}