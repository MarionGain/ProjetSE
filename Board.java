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

class Board extends JPanel implements ActionListener{

    private Image i;
    private ImageIcon ii;
    private Timer timer;
    private boolean ingame;
    private int B_Width = 1000;
    private int B_Height = 480;

    private Robot robot;
    private Projectile projectile;
    private Monstre monstre;
    private List<Monstre> monstres;
    private Famille famille;

    private Controller control;

    //provisioire pour affichage
    private int nbVies = 3;
    private int score = 100000;
    private int numJoueur = 1;

    //image de fond

    private FondDrol fond [] = new FondDrol[23];
    private int choixFond;

    private Trappe trappe;
    private List<Trappe> trappes;
    private int largeurTrappe = 50;
    private int hauteurTrappe = 10;

    private Etage etage;
    private List<Etage> etages;
    private int nbEtages = 4;

    private int posInitX ;
    private int posInitY ;

    private int posCouranteX;
    private int posCouranteY;

    private int vitesse = 15;

    //constructeur du Jpanel Board
    public Board(){

        // ajout de l'ecoute des touches
        addKeyListener(new TAdapter());
        setFocusable(true);
        initFond(fond);
        setBackground(Color.black);
        choixFond= (int)(Math.random()*3);

        ingame = true;

        setPreferredSize(new Dimension(B_Width, B_Height));

        initFond(fond);
        setBackground(Color.black);
        choixFond= (int)(Math.random()*23);

        ingame = true;

        setPreferredSize(new Dimension(B_Width, B_Height));

        robot = new Robot();
        projectile = new Projectile(robot);

        trappe = new Trappe();
        trappes = new ArrayList<Trappe>();

        etage = new Etage();
        etages = new ArrayList<Etage>();
        initEtages(etage, etages);

        monstres = new ArrayList<Monstre>();
        initMonstres(monstre, monstres,etages);

        famille = new Famille(etages.get(3),0,2);

        control = new Controller(this);

        // gestion images vitesse
        timer = new Timer(vitesse, this);
        timer.start();
        
    }

    //initialisation du tableau de fond du jeu
    public void initFond(FondDrol [] f){

        f[0] = new FondDrol("Images/Fond/image-1.jpg");
        f[1] = new FondDrol("Images/Fond/image-2.jpg");
        f[2] = new FondDrol("Images/Fond/image-3.jpg");
        f[3] = new FondDrol("Images/Fond/image-4.jpg");
        f[4] = new FondDrol("Images/Fond/image-5.jpg");
        f[5] = new FondDrol("Images/Fond/image-6.jpg");
        f[6] = new FondDrol("Images/Fond/image-7.jpg");
        f[7] = new FondDrol("Images/Fond/image-8.jpg");
        f[8] = new FondDrol("Images/Fond/image-9.jpg");
        f[9] = new FondDrol("Images/Fond/image-10.jpg");
        f[10] = new FondDrol("Images/Fond/image-11.jpg");
        f[11] = new FondDrol("Images/Fond/image-12.jpg");
        f[12] = new FondDrol("Images/Fond/image-13.jpg");
        f[13] = new FondDrol("Images/Fond/image-14.jpg");
        f[14] = new FondDrol("Images/Fond/image-15.jpg");
        f[15] = new FondDrol("Images/Fond/image-16.jpg");
        f[16] = new FondDrol("Images/Fond/image-17.jpg");
        f[17] = new FondDrol("Images/Fond/image-18.jpg");
        f[18] = new FondDrol("Images/Fond/image-19.jpg");
        f[19] = new FondDrol("Images/Fond/image-20.jpg");
        f[20] = new FondDrol("Images/Fond/image-21.jpg");
        f[21] = new FondDrol("Images/Fond/image-22.jpg");
        f[22] = new FondDrol("Images/Fond/image-23.jpg");

    }

    
    public void initEtages(Etage etage, List<Etage> etages){

        //creation liste trappes
        List<Trappe> trappes1 = new ArrayList<Trappe>();
        trappes1.add(new Trappe());
        trappes1.add(new Trappe());
        List<Trappe> trappes2 = new ArrayList<Trappe>();
        trappes2.add(new Trappe());
        List<Trappe> trappes3 = new ArrayList<Trappe>();
        trappes3.add(new Trappe());
        trappes3.add(new Trappe());

        //creation des etage
        etages.add(new Etage(trappes1,B_Height-9 * (B_Height/16)-10));
        etages.add(new Etage(trappes2,B_Height-6* (B_Height/16)-10));
        etages.add(new Etage(trappes3,B_Height-3 * (B_Height/16)-10));
        etages.add(new Etage(B_Height-10));

        //attribution des positions aux trappes

        //etage 3
        Position p = new Position(80,etages.get(0).getPosition().getY());
        etages.get(0).getListTrappes().get(0).setPosition(p);
        Position p1 = new Position(B_Width - (80+largeurTrappe),etages.get(0).getPosition().getY());
        etages.get(0).getListTrappes().get(1).setPosition(p1);

        //etage 2 
        Position p2 = new Position((B_Width/2)-(largeurTrappe/2),etages.get(1).getPosition().getY());
        etages.get(1).getListTrappes().get(0).setPosition(p2);

        //etage 1
        Position p3 = new Position(80,etages.get(2).getPosition().getY());
        etages.get(2).getListTrappes().get(0).setPosition(p3);
        Position p4 = new Position(B_Width - (80+largeurTrappe),etages.get(2).getPosition().getY());
        etages.get(2).getListTrappes().get(1).setPosition(p4);

    }

    public void initMonstres(Monstre monstre, List<Monstre> monstres, List<Etage> etages){

        monstres.add(new Monstre(etages.get(0),50,2));
        monstres.add(new Monstre(etages.get(0),B_Width-80,1));
        monstres.add(new Monstre(etages.get(1),50,2));
        monstres.add(new Monstre(etages.get(1),B_Width-80,1));
        monstres.add(new Monstre(etages.get(2),50,2));
        monstres.add(new Monstre(etages.get(2),B_Width-80,1));
        monstres.add(new Monstre(etages.get(3),50,2));
        monstres.add(new Monstre(etages.get(3),B_Width-100,1));
        monstres.add(new Monstre(etages.get(3),20,2));
        monstres.add(new Monstre(etages.get(3),B_Width-50,1));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doFond(g,fond,choixFond);
        doMap(g,etages,trappes);
        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }

    //affichage du fond
    public void doFond(Graphics g, FondDrol [] f, int choix){

        g.drawImage(f[choix].getImage(),0,0, this);

    }

    //affichage de la map

    public void doMap(Graphics g, List<Etage> etages, List<Trappe> trappes){

        Color c = g.getColor();
        Color violet = new Color(85,37,112);
        Color rose = new Color(252,35,255);
        Font f = new Font(Font.SERIF, Font.BOLD, 80);
        Font f2 = new Font(Font.SERIF, Font.BOLD, 20);

        g.setColor(violet);

        //peut faire une petite banderole sympa et permet de voir le fond
        //g.fillRect(0,(B_Height/4)-15,B_Width,10); // x,Y,largeur,hauteur
        g.fillRect(0,0,B_Width,B_Height/4);

        g.setColor(rose);
        g.setFont(f);
        g.drawString("DROL",(B_Width/2)-125,20+B_Height/8);

        g.setFont(f2);
        g.drawString("JOUEUR " + numJoueur,B_Width/8-120,B_Height/8-20);
        g.drawString("SCORE      " + score,B_Width/8-120,B_Height/8+10);

        g.drawString("NOMBRE DE VIES     " + robot.getNbVies(),B_Width/8-120,B_Height/8+40);
        g.drawString("HIGHSCORE",3*B_Width/4+40,B_Height/8-20);
        

        g.setColor(Color.BLUE);
        g.fillRect(50+B_Width/4,0,10,B_Height/4);

        g.fillRect(3*B_Width/4-50,0,10,B_Height/4);

        for(Etage etage : etages){
            g.setColor(Color.GRAY);
            etage.doEtage(g,etage.getPosition().getX(), etage.getPosition().getY(),B_Width,10); 

            //condition necessaire: le rez de chaussee n a pas de trappe
            if(etage.getListTrappes() != null){
                for(Trappe trappe : etage.getListTrappes()){
                    if(trappe.isVisible() == true){
                        g.setColor(violet);
                    }
                    else{
                        g.setColor(Color.BLACK);
                    }
                    trappe.doTrappe(g, trappe.getPosition().getX(), trappe.getPosition().getY());
                }
            }
        }
 
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

        int i = 0;
        for(Monstre monstre : monstres){
            if(monstres.get(i).isVisible()){
                g2d.drawImage(monstres.get(i).getImage(), monstres.get(i).getPosition().getX(),monstres.get(i).getPosition().getY(), this);
            }
            i++;
        }

        if(famille.isVisible()){
            g2d.drawImage(famille.getImage(),famille.getPosition().getX(),famille.getPosition().getY(),this);
        }
    }

    public void actionPerformed(ActionEvent evt){
        control.testCollision();
        control.moveRobot();
        control.moveMonstre();
        control.updateMonstre();
        control.updateProjectile();
        control.moveFamille();
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

    public Monstre getMonstre(){
        return this.monstre;
    }

    public List<Monstre> getListMonstres(){
        return this.monstres;
    }

    public Famille getFamille(){
        return this.famille;
    }

    public Etage getEtage(){
        return this.etage;
    }
    public List<Etage> getListEtages(){
        return this.etages;
    }

    public Trappe getTrappe(){
        return this.trappe;
    }
    public List<Trappe> getListTrappes(){
        return this.trappes;
    }
}