package gonki;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Enemy<a> {
    public static final int MAX_Y = 625;
    public static final int MIN_Y = 65;
    int x;
    int y;
    int v;
    int flag = 0;
    int arr[] = new int[]{65, 270, 470, 675};
    int sdvig = 0;
    Image img;
    Road road;

    Random raand = new Random();
    int a = raand.nextInt(2);



    public Enemy(int x, int y, int v, int image, Road road) {
        this.x = x;
        if (y == 0)
            this.y = 65;
        if (y == 1)
            this.y = 270;
        if (y == 2)
            this.y = 470;
        if (y == 3)
            this.y = 675;
        this.v = v;
        this.road = road;
        if (image == 0)
            this.img = new ImageIcon("src/main/resources/enemy1.png").getImage();
        if (image == 1)
            this.img = new ImageIcon("src/main/resources/enemy2.png").getImage();
        if (image == 2)
            this.img = new ImageIcon("src/main/resources/enemy3.png").getImage();

    }

    public Rectangle getRectangle() {                 // прямоугольник, по которому судим, произошло столкновение или нет
        return new Rectangle(x, y, 260, 140);
    }

    public void move() {
        int b = arr[raand.nextInt(3)];
        x = x - road.p.v + v;
        if (flag == 1) {

            if (a == 0 && sdvig < b) {
                y += 2;
                sdvig +=2;
            }
            if (a == 1 && sdvig < b) {
                y -= 2;
                sdvig +=2;
            }
            if (y <= MIN_Y) y = MIN_Y;
            if (y >= MAX_Y) y = MAX_Y;

        }
    }

}


