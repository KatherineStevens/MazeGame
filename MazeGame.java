import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import javax.swing.JOptionPane;
import java.util.Random;

// https://www.youtube.com/watch?v=p9Y-NBg8eto
public class MazeGame extends JPanel implements ActionListener, KeyListener {

  Timer t = new Timer(5, this); // every 5 milliseconds will call action listener
  double x = 20; // to set  initial coordinates of object
  double y = 20;
  double velx = 0;
  double vely = 0;

  public MazeGame() { // constructor

    t.start(); // start timer
    addKeyListener(this); // add the key listener
    setFocusable(true); // sets focus to key listener
    setFocusTraversalKeysEnabled(false); // reduces unexpected key actions

  } // end constructor

  public static double[] createXArray() {

    double[] starXCoor = new double[75];

    Random randGen = new Random();

    for (int i = 0; i < starXCoor.length; i++) {
      starXCoor[i] = Double.valueOf(randGen.nextInt(800));
    }

    return starXCoor;
  }

  public static double[] createYArray() {

    double[] starYCoor = new double[75];

    Random randGen = new Random();

    for (int i = 0; i < starYCoor.length; i++) {
      starYCoor[i] = Double.valueOf(randGen.nextInt(600));
    }
    return starYCoor;
  }

  double[] starXCoor = createXArray();
  double[] starYCoor = createYArray();

  public void paintComponent(Graphics g) { // to add shape
    super.paintComponent(g);
    Graphics2D mazeLines = (Graphics2D) g;
    Graphics2D alien = (Graphics2D) g;
    Graphics2D planet = (Graphics2D) g;
    Graphics2D stars = (Graphics2D) g;
    //g2.setColor(Color.black);
    //g2.fillRect(0, 0, 800, 600);

    setBackground(Color.black);

    stars.setColor(Color.white);

    for (int i = 0; i < 75; i++) {

      stars.fill(new Ellipse2D.Double(starXCoor[i], starYCoor[i], 4, 4));

    }

    mazeLines.setColor(Color.yellow);
    mazeLines.draw(new Rectangle2D.Double(0, 0, 800, 600));

    mazeLines.draw(new Line2D.Double(0, 100, 700, 100));
    mazeLines.draw(new Line2D.Double(100, 200, 800, 200));
    mazeLines.draw(new Line2D.Double(0, 300, 700, 300));
    mazeLines.draw(new Line2D.Double(700, 300, 700, 500));
    mazeLines.draw(new Line2D.Double(600, 600, 600, 400));
    mazeLines.draw(new Line2D.Double(500, 300, 500, 500));
    mazeLines.draw(new Line2D.Double(400, 600, 400, 400));
    mazeLines.draw(new Line2D.Double(300, 300, 300, 500));

    alien.setColor(Color.green);
    alien.fill(new Ellipse2D.Double(x, y, 40, 65));

    alien.draw(new Line2D.Double(x, y, x + 10, y + 10));

    alien.draw(new Line2D.Double(x + 40, y, x + 30, y + 10));

    alien.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));

    alien.fill(new Ellipse2D.Double(x + 38, y - 2, 4, 4));

    alien.setColor(Color.black);
    alien.fill(new Ellipse2D.Double(x + 8, y + 20, 10, 25));

    alien.fill(new Ellipse2D.Double(x + 22, y + 20, 10, 25));

    alien.fill(new Ellipse2D.Double(x + 16, y + 50, 8, 8));

    planet.setColor(Color.blue);
    planet.fill(new Ellipse2D.Double(100, 400, 100, 100));

    planet.setColor(Color.gray);
    planet.draw(new QuadCurve2D.Double(100, 450, 40, 510, 160, 460));
    planet.draw(new QuadCurve2D.Double(160, 460, 260, 405, 180, 410));
    planet.setColor(Color.magenta);
    planet.fill(new Ellipse2D.Double(205, 420, 10, 10));
    planet.setColor(Color.orange);
    planet.fill(new Ellipse2D.Double(80, 463, 10, 10));
  }

  public Boolean checkCollision(double x, double y) {

    if (x == 0 || x == 760 || y == 0 || y == 535) {
      return true;
    }
    if (x >= 0 && x <= 700 && y == 35) { // horiz
      return true;
    }
    if (x >= 0 && x <= 700 && y == 100) { //horiz
      return true;
    }
    if (x >= 100 && x <= 760 && y == 135) { //horiz
      return true;
    }
    if (x >= 100 && x <= 760 && y == 200) { //horiz
      return true;
    }
    if (x >= 0 && x <= 700 && y == 235) { // horiz
      return true;
    }
    if (x >= 0 && x <= 700 && y == 300) { // horiz
      return true;
    }
    if (x == 700 && y >= 35 && y <= 100) { // edge
      return true;
    }
    if (x == 60 && y >= 135 && y <= 200) { // edge
      return true;
    }
    if (x == 700 && y >= 235 && y <= 300) { // edge
      return true;
    }

    if (x == 700 && y >= 235 && y <= 500) { // vert
      return true;
    }
    if (x == 660 && y >= 300 && y <= 500) { // vert
      return true;
    }
    if (x == 600 && y >= 335 && y <= 535) { // vert
      return true;
    }
    if (x == 560 && y >= 335 && y <= 535) { //vert
      return true;
    }
    if (x == 500 && y >= 300 && y <= 500) { // vert
      return true;
    }
    if (x == 460 && y >= 300 && y <= 500) { // vert
      return true;
    }
    if (x == 400 && y >= 335 && y <= 535) { // vert
      return true;
    }
    if (x == 360 && y >= 335 && y <= 535) { //vert
      return true;
    }
    if (x == 300 && y >= 300 && y <= 500) { // vert
      return true;
    }
    if (x == 260 && y >= 300 && y <= 500) { // vert
      return true;
    }
    if (x >= 660 && x <= 700 && y == 500) { // edge
      return true;
    }
    if (x >= 560 && x <= 600 && y == 335) { // edge
      return true;
    }
    if (x >= 460 && x <= 500 && y == 500) { // edge
      return true;
    }
    if (x >= 360 && x <= 400 && y == 335) { // edge
      return true;
    }
    if (x >= 260 && x <= 300 && y == 500) { // edge
      return true;
    }

    return false;

  }

  public Boolean checkHome(double x, double y) {
    if (x == 200 && y >= 335 && y <= 500) { // from right
      return true;
    }
    if (x == 60 && y >= 335 && y <= 500) { // from left
      return true;
    }
    if (x >= 60 && x <= 200 && y == 335) { // from top
      return true;
    }
    if (x >= 60 && x <= 200 && y == 500) { // from bottom
      return true;
    }
    return false;
  }

  public void actionPerformed(ActionEvent e) {
    repaint(); // repaints graphic every 5 millisecond
    x += velx;
    y += vely;
    if (checkCollision(x, y) == true) {
      x = 20;
      y = 20;
      velx = 0;
      vely = 0;
    }
    if (checkHome(x, y) == true) {
      String message = "You got the alien home!";
      JOptionPane.showConfirmDialog(null, message, "CONGRATULATIONS",
                  JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

      x = 20;
      y = 20;
      velx = 0;
      vely = 0;
    }
  }

  public void up() { // make methods for each key to change position
    vely = -1;
    velx = 0;
  }

  public void down() {
    vely = 1;
    velx = 0;
  }

  public void left() {
    velx = -1;
    vely = 0;
  }

  public void right() {
    velx = 1;
    vely = 0;
  }

  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == KeyEvent.VK_UP) { // check code, call function associated to move
      up();
    }
    if (code == KeyEvent.VK_DOWN) {
      down();
    }
    if (code == KeyEvent.VK_LEFT) {
      left();
    }
    if (code == KeyEvent.VK_RIGHT) {
      right();
    }
  }

  public void keyTyped(KeyEvent e) {} // have to add other 2 key listener methods even if not using

  public void keyReleased(KeyEvent e) {}

  public static void main(String[] args) {
    JFrame gameFrame = new JFrame();
    game myGame = new game();

    gameFrame.setResizable(false);
    myGame.setPreferredSize(new Dimension(800, 600));
    gameFrame.setTitle("Help the alien get home!");
    gameFrame.add(myGame);
    gameFrame.pack();
    gameFrame.setLocationRelativeTo(null);
    gameFrame.setVisible(true);
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}// end game class
