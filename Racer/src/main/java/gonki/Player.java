package gonki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public static final int MAX_V = 80;
    public static final int MAX_TOP = 40;
    public static final int MAX_BOTTOM = 735;

    Image img = new ImageIcon("src/main/resources/car.png").getImage();

    int v = 0;
    int dv = 0;
    int s = 0;

    int x = 30;
    int y = 78;
    int dy = 0;

    int layer1 = 0;
    int layer2 = 758;

    public void move() {
        s += v;
        v += dv;
        if (v <= 0) v = 0;
        if (v > MAX_V) v = MAX_V;
        y -= dy;
        if (y <= MAX_TOP) y = MAX_TOP;
        if (y >= MAX_BOTTOM) y = MAX_BOTTOM;
        if (layer2 - v <= 0) {
            layer1 = layer2 - v;
            layer2 = layer2 - v + 758;
        } else {
            layer1 -= v;
            layer2 -= v;
        }
    }

    public void keyPressed(KeyEvent e) {              //операции при нажатии кнопок
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            dv = 1;
        }
        if (key == KeyEvent.VK_LEFT) {
            dv = -1;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 10;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = -10;
        }

    }

    public void keyReleased(KeyEvent e) {         //операции при опущенных кнопках
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
            dv = 0;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }

    }

    public Rectangle getRect() {                            //определяем границу столкновения
        return new Rectangle(x, y, 260, 120);
    }

}