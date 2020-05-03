package stackCalc;

import stackCalc.exceptions.BadCmdException;
import stackCalc.exceptions.FactoryException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class CommandFactory {
    private static final Logger logger = Logger.getLogger(CommandFactory.class.getSimpleName());
    private Map<String, String> commandConf = new HashMap<>();           //команда и полное имя класса
    private static CommandFactory instance = new CommandFactory();

    private CommandFactory() {
        Properties prop = new Properties();
        try (InputStream config = CommandFactory.class.getResourceAsStream("cmd.properties")) {
            prop.load(config);     //загрузила все настройки из кмд пропертис
        } catch (IOException e) {
            logger.info("Unable to open config stream");
        }

        for (String strCmd : prop.stringPropertyNames())
            commandConf.put(strCmd, prop.getProperty(strCmd));   // заношу комманду и полное имя класса в хэшмапу
    }

    public static CommandFactory getInstance() {
        return instance;
    }

    public Command getCmd(String cmdName) throws FactoryException {
        if (commandConf.containsKey(cmdName.toLowerCase())) {
            try {
                Class c;
                c = Class.forName(commandConf.get(cmdName.toLowerCase()));//возвращаю класс по имени класса
                return (Command) c.newInstance();                  //вызов конструктора нулевого парам
            } catch (Exception e) {
                throw new FactoryException("Unable to instance the class");
            }
        } else
            throw new BadCmdException("no such command in config");
    }
}
