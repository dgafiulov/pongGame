import java.awt.event.KeyEvent;

public class Enemy extends Player {

    private final int X = Display.WIDTH - getWIDTH() - 25;
    private int y = 100;
    //private int score = 0;

    public enum Direction {
        UP,
        DOWN,
        NONE
    }

    @Override
    public int getX() {
        return X;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) { this.y = y; }

    static public Direction enemyDirection = Direction.NONE;

    public static void KeyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            enemyDirection = Direction.UP;
        }

        else if (key == KeyEvent.VK_DOWN) {
            enemyDirection = Direction.DOWN;
        }

        else if (key == KeyEvent.VK_RIGHT) {
            enemyDirection = Direction.NONE;
        }

    }

    @Override
    public void move() {
        switch (enemyDirection) {
            case UP:
                if (y >= 0) {
                    y -= SPEED;
                }
                break;
            case DOWN:
                if ((y + getHEIHT()) <= Display.HEIGHT) {
                    y += SPEED;
                }
                break;
        }
    }

}
