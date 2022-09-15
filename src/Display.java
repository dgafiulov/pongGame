import javax.swing.*;

public class Display {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    public static void main(String[] args) {

        System.out.println(Display.WIDTH - Enemy.getWIDTH() - 25);

        JFrame frame = new JFrame("pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH + 12, HEIGHT + 35);
        frame.setResizable(false);
        frame.add(new Main(frame));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}