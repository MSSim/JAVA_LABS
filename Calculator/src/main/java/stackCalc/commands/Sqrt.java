package stackCalc.commands;

import stackCalc.Command;
import stackCalc.exceptions.CommandException;

import java.util.Map;
import java.util.Stack;

public class Sqrt implements Command {
    public void execute(Map<String, Double> define, Stack<Double> stack, String[] s)throws CommandException {
        if (stack.empty())
            throw new CommandException("stack is empty");

        stack.push(Math.sqrt(stack.pop()));
    }
}
