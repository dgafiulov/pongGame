import java.awt.*;
import java.awt.event.KeyEvent;

public class Enemy extends Character {

    public Enemy() {
        x = Display.WIDTH - getWIDTH() - 25;
        y = 100;
        c = Color.red;
        scoreY = 40;
    }

    public void KeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> dir = Direction.UP;
            case KeyEvent.VK_DOWN -> dir = Direction.DOWN;
            case KeyEvent.VK_RIGHT -> dir = Direction.NONE;
        }
    }
}
