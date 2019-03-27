import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


class Board extends JPanel implements ActionListener{
    private Image i;
    private ImageIcon ii;
    private Timer timer;

    private Robot robot;
    private Controller control;


    private int posInitX ;
    private int posInitY ;

    private int posCouranteX;
    private int posCouranteY;

    private int vitesse = 3;

    //constructeur du Jpanel Board
    public Board(){
        setBackground(Color.black);

        addKeyListener(new TAdapter());
        setFocusable(true);

        robot = new Robot();
        control = new Controller(robot);

        timer = new Timer(vitesse, this);
        timer.start();
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(robot.getImage(), robot.getPosition().getX(), robot.getPosition().getY(), this);
    }


    public void actionPerformed(ActionEvent evt){
        step();
    }

    private void step() {
        control.move();
        repaint(robot.getPosition().getX()-1, robot.getPosition().getY()-1, robot.getWidth()+2, robot.getHeight()+2);     
    }  

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            control.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            control.keyPressed(e);
        }
    }
}