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


//ajout1 de la methode tirer appelant tir()


class Board extends JPanel implements ActionListener{
    private Image i;
    private ImageIcon ii;
    private Timer timer;

    private Robot robot;
    private Projectile projectile;
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
        projectile = new Projectile(robot);
        control = new Controller(robot,projectile);

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
        //ajout2
        if(projectile.isVisible()==true){
            g2d.drawImage(projectile.getImage(), projectile.getPosition().getX(),projectile.getPosition().getY(), this);
        }
    }

    public void actionPerformed(ActionEvent evt){
        control.move();
        control.updateProjectile();
        
        //changement de place
        repaint();
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