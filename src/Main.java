import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JPanel implements ActionListener {

    //creating all we need
    Timer timer = new Timer(1, this);
    static Font scoreFont = new Font("Arial", Font.PLAIN, 20);
    Font menuFont = new Font("Arial", Font.PLAIN, 40);
    Font headerFont = new Font("Arial", Font.PLAIN, 100);
    int[] img1 = {0, 0, Display.WIDTH, Display.HEIGHT};
    JFrame frame;
    private boolean gameStarted = false;

    static Player player = new Player();
    static Ball ball = new Ball();
    static Enemy enemy = new Enemy();

    //methods
    public Main(JFrame frame) {
        timer.start();
        this.frame = frame;

        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                player.KeyPressed(e);
                enemy.KeyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    gameStarted = true;
                }
            }
        });
    }

    public void paint(Graphics g) {

        if (gameStarted) {
            g.setColor(Color.black);
            g.fillRect(0, 0, Display.WIDTH, Display.HEIGHT);
            player.draw(g);
            g.setColor(ball.ballColor);
            g.fillOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
            enemy.draw(g);

        }
        else {
            g.setColor(Color.black);
            g.fillRect(0, 0, Display.WIDTH, Display.HEIGHT);
            g.setColor(Color.white);
            g.setFont(headerFont);
            g.drawString("Simple pong", 325, 90);
            g.setFont(menuFont);
            g.setColor(Color.cyan);
            g.drawString("W - up", 100, 250);
            g.drawString("S - down", 100, 290);
            g.drawString("A - stop", 100, 330);
            g.setColor(Color.red);
            g.drawString("↑ - up", 900, 250);
            g.drawString("↓ - down", 900, 290);
            g.drawString("→ - stop", 900, 330);
            g.setColor(Color.white);
            g.drawString("Press space to start",  400, 600);
        }
    }

    @Override
        public void actionPerformed(ActionEvent e) {

        if (gameStarted) {
            ball.move();
            player.move();
            enemy.move();
            repaint();
        }
    }
}
