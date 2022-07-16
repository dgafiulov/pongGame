import java.awt.event.KeyEvent;

public class Player {

    private static KeyEvent e;
    //creating all we need
    private final int WIDTH = 25;
    private final int HEIGHT = 200;
    private final int X = 25;
    private static int y = 100;
    public int score = 0;
    static final int SPEED = 7;

    public enum Direction {
        UP,
        DOWN,
        NONE
    }

    static public Direction playerDirection = Direction.NONE;

    //methods
    public int getX() {
        return X;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) { this.y = y; }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIHT() {
        return HEIGHT;
    }

    public void move() {
        switch (playerDirection) {
            case UP:
                if (y >= 0) {
                    y -= SPEED;
                }
                break;
            case DOWN:
                if ((y + HEIGHT) <= Display.HEIGHT) {
                    y += SPEED;
                }
                break;
        }
    }

    public static void KeyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            playerDirection = Direction.UP;
        }

        else if (key == KeyEvent.VK_S) {
            playerDirection = Direction.DOWN;
        }

        else if (key == KeyEvent.VK_A) {
            playerDirection = Direction.NONE;
        }

    }

    public static void KeyReleased(KeyEvent e) {

        //playerDirection = Direction.NONE;
    }
}
