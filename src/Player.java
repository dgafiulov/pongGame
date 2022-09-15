import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Character {

    public Player() {
        x = 25;
        y = 100;
        c = Color.cyan;
        scoreY = 20;
    }

    public void KeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> dir = Direction.UP;
            case KeyEvent.VK_S -> dir = Direction.DOWN;
            case KeyEvent.VK_A -> dir = Direction.NONE;
        }
    }
}
