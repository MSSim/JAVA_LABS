package stackCalc;

import stackCalc.exceptions.BadCmdException;
import stackCalc.exceptions.FactoryException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;

public class Run {

    private static final Logger logger = Logger.getLogger(Run.class.getSimpleName());

    Stack<Double> stack = new Stack<>(); //стек
    Map<String, Double> define = new HashMap<>(); //дефайны

    public void run(String file) throws FileNotFoundException {
        Scanner sc;
        if (file.equals(""))
            sc = new Scanner(System.in);
        else
            sc = new Scanner(new FileInputStream(file));

        String str;

        while (sc.hasNextLine()) {       // пока есть строка
            str = sc.nextLine();
            if (str.charAt(0) == '#')
                continue;
            String[] s = str.split(" ");   // распарсила строку
            Command cmd;
            try {
                cmd = CommandFactory.getInstance().getCmd(s[0]);
            } catch (BadCmdException e) {
                logger.info("bad command, try again!");
                continue;
            } catch (FactoryException e) {
                logger.info(e.getMessage());
                return;
            }

            try {
                cmd.execute(define, stack, s);
            } catch (Exception e) {
                logger.info(e.getMessage());
            }
        }
    }
}
