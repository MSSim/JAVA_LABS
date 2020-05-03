package stackCalc.commands;

        import org.junit.Test;

        import java.util.HashMap;
        import java.util.Map;
        import java.util.Stack;

        import static org.junit.Assert.assertEquals;

public class PopTest {

    @Test
   public void execute() {
        Pop p = new Pop();
        Map<String, Double> define = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        String[] s = new String[0];
        int expected = 0;
        try {
            p.execute(define, stack, s);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expected, stack.size());
    }

    @org.junit.jupiter.api.Test
    void testExecute() {
    }
}