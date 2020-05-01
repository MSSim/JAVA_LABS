package stackCalc;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getSimpleName());
    public static void main(String[] args){
        logger.info("start! ");
        Run a = new Run();
        try {
            if (args.length == 1)
                a.run(args[0]);
            else if (args.length > 1)
                System.out.println("Too many arguments");
            else {
                a.run("");
            }
        }catch(Exception e){
            System.out.println("message: " + e.getMessage());
        }
    }
}
