package gonki;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    int x;
    int y;
    int v;
    Image img;
    Road road;

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

    public Rectangle getRectangle(){                 // прямоугольник, по которому судим, произошло столкновение или нет
        return new Rectangle(x,y,260,140);
    }

    public void move() {
        x = x - road.p.v + v;                         //меняем положение на дороге, опираясь на скорость игрока.
    }
}


