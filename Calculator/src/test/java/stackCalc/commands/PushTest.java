package stackCalc.commands;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class PushTest {

    @Test
    public void execute() {
        Push p = new Push();
        Map<String, Double> define = new HashMap<>();
        define.put("a", 4.0);
        Stack<Double> stack = new Stack<>();
        String[] s = new String[2];
        s[1] = "a";
        Double expected = 4.0;
        try {
            p.execute(define, stack, s);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expected, stack.pop());
    }

    @org.junit.jupiter.api.Test
    void testExecute() {
    }
}