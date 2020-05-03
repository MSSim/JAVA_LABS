package stackCalc.commands;
        import org.junit.Test;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Stack;
        import static org.junit.Assert.assertEquals;

public class MultTest {

    @Test
   public void execute() {
        Mult m = new Mult();
        Map<String, Double> define = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        stack.push(3.0);
        stack.push(2.0);
        String[] s = new String[0];
        Double expected = 6.0;
        try {
            m.execute(define, stack, s);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expected, stack.pop());
    }

    @org.junit.jupiter.api.Test
    void testExecute() {
    }
}