package gonki;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Audio implements Runnable {
    @Override
    public void run() {

        try {
            try {
                Player p = new Player(new FileInputStream(("src/main/resources/Руки Вверх - Крошка Моя.mp3")));
                p.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
