package gonki;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Road extends JPanel implements ActionListener, Runnable {

    Timer mainTimer = new Timer(20, this);                        //каждый 2 мс выполняет экшнперформед у this
    Image img = new ImageIcon("src/main/resources/road.png").getImage();
    Player p = new Player();
    Thread enemiesFactory = new Thread(this);        //this реализует интерфейс ранэбл, имеющий единственную функцию run
    Thread audioThread = new Thread(new Audio());           //еще один поток
    List<Enemy> enemies = new ArrayList<>();
    int level;
    // создаем лист врагов

    public Road() {
        mainTimer.start();
        enemiesFactory.start();
        audioThread.start();                  // run внутри Audio
        addKeyListener(new MyKeyAdapter());      //чтобы следить за нажатыми клавишами
        setFocusable(true);
        level = JOptionPane.showConfirmDialog(null, "Хотите включить сложный уровень?", "выбор уровня", JOptionPane.YES_NO_OPTION);
    }

    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
        testCollision();
        testWin();
    }

    @Override
    public void run() {
        while (true) {
            Random rand = new Random();
            try {
                Thread.sleep(rand.nextInt(2000) + 1200, 500);
                enemies.add(new Enemy(1600, rand.nextInt(4), 50, rand.nextInt(3), this));
                if (level == 0)
                    enemies.get(rand.nextInt(enemies.size())).flag = 1;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }
    }

    public void paint(Graphics g) {                                          //вызывается сам
        g.drawImage(img, p.layer1, 0, null);
        g.drawImage(img, p.layer2, 0, null);
        g.drawImage(p.img, p.x, p.y, 250, 140, null);
        Toolkit.getDefaultToolkit().sync();
        Iterator<Enemy> i = enemies.iterator();

        while (i.hasNext()) {
            Enemy e = i.next();
            if (e.x >= 2400 || e.x <= -2400) {
                i.remove();
            } else
                e.move();
            g.drawImage(e.img, e.x, e.y, null);

        }
        double v = (200 / Player.MAX_V) * p.v;
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.ITALIC, 30);
        g.setFont(font);
        g.drawString("Скорость: " + v + "км/ч", 40, 30);
        g.drawString("Дистанция: " + p.s + " из 200000", 400, 30);
        Toolkit.getDefaultToolkit().sync();

    }

    private void testWin() {
        if (p.s > 200000) {
            JOptionPane.showMessageDialog(null, "ПОБЕДА!");
            System.exit(0);
        }
    }

    private void testCollision() {
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();
            if (p.getRect().intersects(e.getRectangle())) {
                JOptionPane.showMessageDialog(null, "Вы проиграли!");
                System.exit(1);
            }
        }
    }
}
