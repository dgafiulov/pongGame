import java.awt.*;

public class Ball {
    private int x = 500;
    private int y = 300;
    private int speed = 5;
    private int size = 40;
    private int amountOfCollisions = 0;

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

    private boolean collisionWithPlayer() {

        return x <= Main.player.getX() + Main.player.getWIDTH() & x >= Main.player.getX() & y > Main.player.getY() & y < (Main.player.getY() + Main.player.getHEIHT());
    }

    private boolean collisionWithEnemy() {

        return x + size >= Main.enemy.getX() & x <= (Main.enemy.getX() + Main.enemy.getWIDTH()) & y > Main.enemy.getY() & y < (Main.enemy.getY() + Main.enemy.getHEIHT());
    }

    private boolean outOfWorldOnPlayerSide() {

        return x <= 0;
    }

    private boolean outOfWorldOnEnemySide() {

        return x + size >= Display.WIDTH;
    }

    //move
    public void move() {
        x += speed * xCoef;
        y += speed * yCoef;

        //colissions
        if (outOfWorldOnPlayerSide()) {
            Main.player.setY(100);
            Main.enemy.setY(100);
            x = 500;
            y = 300;
            Main.player.playerDirection = Player.Direction.NONE;
            Main.enemy.enemyDirection = Enemy.Direction.NONE;
            Main.enemy.score++;
            speed = 5;
            amountOfCollisions = 0;
            ballColor = Color.white;
        }
        if (outOfWorldOnEnemySide()) {
            Main.player.setY(100);
            Main.enemy.setY(100);
            x = 500;
            y = 300;
            Main.player.playerDirection = Player.Direction.NONE;
            Main.enemy.enemyDirection = Enemy.Direction.NONE;
            Main.player.score++;
            speed = 5;
            amountOfCollisions = 0;
            ballColor = Color.white;
        }
        if ((y + size >= Display.HEIGHT) | (y <=  0)) {
            yCoef *= -1;
        }
        if (collisionWithPlayer())  {
            xCoef *= -1;
            if (amountOfCollisions < 5) {
                ballColor = Color.cyan;
            }
            amountOfCollisions++;
        }
        if (collisionWithEnemy()) {
            xCoef *= -1;
            if (amountOfCollisions < 5) {
                ballColor = Color.red;
            }
            amountOfCollisions++;
        }
        if(amountOfCollisions == 5) {
            ballColor = Color.yellow;
            speed = 10;
        }
    }
}
