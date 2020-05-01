package stackCalc.commands;

        import org.junit.Test;

        import java.util.HashMap;
        import java.util.Map;
        import java.util.Stack;

        import static org.junit.Assert.assertEquals;

class DivTest {

    @Test
    public void execute() {
        Div d = new Div();
        Map<String, Double> define = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        Double a = 0.3;
        Double b = 2.1;
        stack.push(a);
        stack.push(b);
        String[] s = new String[0];
        Double expected = b/a;
        try {
            d.execute(define, stack, s);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expected, stack.pop());
    }

    @org.junit.jupiter.api.Test
    void testExecute() {
    }
}