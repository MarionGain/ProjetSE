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

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.List;


//ajout1 de la methode tirer appelant tir()


class Board extends JPanel implements ActionListener{

    private Image i;
    private ImageIcon ii;
    private Timer timer;
    private boolean ingame;
    private int B_Width = 1000;
    private int B_Height = 480;

    private Robot robot;
    private Projectile projectile;
    private Controller control;

    //provisioire pour affichage
    private int nbVies = 3;
    private int score = 100000;
    private int numJoueur = 1;

    //image de fond
    private FondDrol fond [] = new FondDrol[3];
    private int choixFond;


    private int posInitX ;
    private int posInitY ;

    private int posCouranteX;
    private int posCouranteY;

    private int vitesse = 15;

    

    //constructeur du Jpanel Board
    public Board(){

        addKeyListener(new TAdapter());
        setFocusable(true);
        initFond(fond);
        setBackground(Color.black);
        choixFond= (int)(Math.random()*3);

        ingame = true;

        setPreferredSize(new Dimension(B_Width, B_Height));

        robot = new Robot();
        projectile = new Projectile(robot);
        control = new Controller(this);

        timer = new Timer(vitesse, this);
        timer.start();
        
    }

    //initialisation du tableau de fond du jeu
    public void initFond(FondDrol [] f){
        f[0] = new FondDrol("fond1.png");
        f[1] = new FondDrol("fond2.png");
        f[2] = new FondDrol("fond3.png");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doFond(g,fond,choixFond);
        doMap(g);
        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }

    //affichage du fond
    public void doFond(Graphics g, FondDrol [] f, int choix){

        g.drawImage(f[choix].getImage(),0,0, this);

    }

    //affichage de la map
    public void doMap(Graphics g){
        Color c = g.getColor();
        Color violet = new Color(85,37,112);
        Color rose = new Color(252,35,255);
        Font f = new Font(Font.SERIF, Font.BOLD, 80);
        Font f2 = new Font(Font.SERIF, Font.BOLD, 20);

        g.setColor(violet);
        g.fillRect(0,(B_Height/4)-15,B_Width,10); // x,Y,largeur,hauteur
        g.fillRect(0,0,1500,B_Height/4);

        g.setColor(rose);
        g.setFont(f);
        g.drawString("DROL",(B_Width/2)-125,20+B_Height/8);

        g.setFont(f2);
        g.drawString("JOUEUR "+numJoueur,B_Width/8-120,B_Height/8-20);
        g.drawString("SCORE      "+score,B_Width/8-120,B_Height/8+10);
        g.drawString("NOMBRE DE VIES     "+nbVies,B_Width/8-120,B_Height/8+40);
        g.drawString("HIGHSCORE",3*B_Width/4+40,B_Height/8-20);
        

        g.setColor(Color.BLUE);
        g.fillRect(50+B_Width/4,0,10,B_Height/4);

        g.fillRect(3*B_Width/4-50,0,10,B_Height/4);


        g.setColor(Color.GRAY);
        g.fillRect(0,B_Height-9*(B_Height/16)-10,B_Width,10);

        g.setColor(Color.GRAY);
        g.fillRect(0,B_Height-3*(B_Height/8)-10,B_Width,10);

        g.setColor(Color.GRAY);
        g.fillRect(0,B_Height-3*(B_Height/16)-10,B_Width,10);

        g.setColor(Color.GRAY);
        g.fillRect(0,B_Height-10,B_Width,10);
 
        g.setColor(c);
    }
    
    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        if(robot.isVisible()){
            g2d.drawImage(robot.getImage(), robot.getPosition().getX(), robot.getPosition().getY(), this);
        }
        
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

    public int getB_Width(){
        return this.B_Width;
    }

    public int getB_Height(){
        return this.B_Height;
    }

    public Robot getRobot(){
        return this.robot;
    }

    public Projectile getProjectile(){
        return this.projectile;
    }
}