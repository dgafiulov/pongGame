import java.awt.*;

public class Ball {
    private int x = 500;
    private int y = 300;
    private final int SPEED = 5;
    private int size = 40;

    private int xCoef = 1;
    private int yCoef = 1;

    public Color ballColor = Color.white;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    private boolean colisionWithPlayer() {

        return x <= Main.player.getX() + Main.player.getWIDTH() & x >= (Main.player.getX() + Main.player.getWIDTH()) - 10 & (y + size / 2) > Main.player.getY() & (y + size / 2) < (Main.player.getY() + Main.player.getHEIHT());
    }

    private boolean colisionWithEnemy() {

        return x + size >= Main.enemy.getX() & x <= (Main.enemy.getX() + Main.enemy.getWIDTH()) + 10 & (y + size / 2) > Main.enemy.getY() & (y + size / 2) < (Main.enemy.getY() + Main.enemy.getHEIHT());
    }

    private boolean outOfWorldOnPlayerSide() {
        return x <= 0;
    }

    private boolean outOfWorldOnEnemySide() {
        return x + size >= Display.WIDTH;
    }

    public void move() {
        x += SPEED * xCoef;
        y += SPEED * yCoef;

        //colissions
        if (outOfWorldOnPlayerSide()) {
            Main.player.setY(100);
            Main.enemy.setY(100);
            x = 500;
            y = 300;
            Main.player.playerDirection = Player.Direction.NONE;
            Main.enemy.enemyDirection = Enemy.Direction.NONE;
            Main.enemy.score++;
        }
        if (outOfWorldOnEnemySide()) {
            Main.player.setY(100);
            Main.enemy.setY(100);
            x = 500;
            y = 300;
            Main.player.playerDirection = Player.Direction.NONE;
            Main.enemy.enemyDirection = Enemy.Direction.NONE;
            Main.player.score++;
        }
        if ((y + size >= Display.HEIGHT) | (y <=  0)) {
            yCoef *= -1;
        }
        if (colisionWithPlayer())  {
            xCoef *= -1;
            ballColor = Color.cyan;
        }
        if (colisionWithEnemy()) {
            xCoef *= -1;
            ballColor = Color.red;
        }
    }
}
