import java.awt.*;
import java.awt.event.KeyEvent;

public class Character {

    private static KeyEvent e;
    //creating all we need
    static final int WIDTH = 25;
    final int HEIGHT = 200;
    final int SPEED = 1;
    protected int x;
    protected int y;
    protected int scoreY;
    protected Color c;
    public int score = 0;

    public enum Direction {
        UP,
        DOWN,
        NONE
    }

    //methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public static int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
    public void setY(int y) { this.y = y; }

    public Direction dir = Direction.NONE;

    public void move() {
        switch (dir) {
            case UP:
                if (y >= 0) {
                    y -= SPEED;
                }
                break;
            case DOWN:
                if ((y + getHEIGHT()) <= Display.HEIGHT) {
                    y += SPEED;
                }
                break;
        }
    }

    public void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setFont(Main.scoreFont);
        g.drawString(String.valueOf(score), 0, scoreY);
    }
}
