package gonki;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame f = new JFrame("Java racer");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//действие при закрытии окна
        f.setSize(1580,905);   // задаем размеры
        f.add(new Road());      //добавляем фрейм
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true); // делаем фрейм видимым
    }
}
