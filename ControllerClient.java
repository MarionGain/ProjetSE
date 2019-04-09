//quand un client va appuyer sur une touche
//classe controller capte la demande
//l envoie au serveur sous forme d une commande( a voir)
//le serveur va modifier les caracteristique du perso et l envoyer a tout le monde y compris le client qui a "fait la demande",
// c est le serveur qui fait bouger le robot
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.net.*;


class ControllerClient extends Controller {



    //etat des touches
    private int kx;
    private int ky;
    private int kt;

    private int emetteur;

    private Robot robot;
    private Projectile projectile;

    private Monstre monstre;
    private List<Monstre> monstres;

    private Famille famille;

    private Etage etage;
    private List<Etage> etages;
    private Trappe trappe;
    private List<Trappe> trappes;

    private Board board;
    private int widthBoard = Consts.B_WIDTH;
    private int heightBoard = Consts.B_HEIGHT;

    private Reception reception;
    private Emission emission;

    private Donnees donnees;

    public ControllerClient(Board b, Socket s){

        this.board = b;
        this.reception = new Reception(this,s);
        this.emission = new Emission(this,s);
        reception.start();

        this.robot = b.getRobot();
        
        this.projectile = b.getProjectile();
        this.monstre = b.getMonstre();
        this.monstres = b.getListMonstres();
        this.famille = b.getFamille();

        this.etage = b.getEtage();
        this.etages = b.getListEtages();
        this.trappe = b.getTrappe();
        this.trappes = b.getListTrappes();

        this.donnees = null;

    }


    public int getEmetteur (){
        return this.emetteur;
    }

    public Board getBoard(){
        return this.board;
    }

    //mise a jour des elements 
    //synchronized necessaire : controller peut être appeler par 2 thread en meme temps
    synchronized public void update(Donnees data){

        //deplacement du robot
        //en multijoueur il faudras une liste de robot + visible
        if(data.isRobot()){
            if(this.robot.getPosition().getX() < data.getArg1()){
                robot.setDirection(Consts.DROITE);
            } 
            else if(this.robot.getPosition().getX() > data.getArg1()){
                robot.setDirection(Consts.GAUCHE);
            }
            this.robot.getPosition().setX(data.getArg1());
            this.robot.getPosition().setY(data.getArg2());
            if(data.getArg3() == Consts.VISIBLE)
                this.robot.setVisible(true);
            else
                this.robot.setVisible(false);
        }

        //deplacement du projectile
        //en multijoueur il faudra une liste de projectile + visibilite
        else if(data.isProjectile()){
            this.projectile.getPosition().setX(data.getArg1());
            this.projectile.getPosition().setY(data.getArg2());
            if(data.getArg3() == Consts.VISIBLE)
                this.projectile.setVisible(true);
            else
                this.projectile.setVisible(false);
        }

         //deplacement des monstres + visibilite
        else if(data.isMonstre()){
            this.monstres.get(data.getObjet()).getPosition().setX(data.getArg1());
            this.monstres.get(data.getObjet()).getPosition().setY(data.getArg2());
            if(data.getArg3() == Consts.VISIBLE)
                this.monstres.get(data.getObjet()).setVisible(true);
            else
                this.monstres.get(data.getObjet()).setVisible(false);
        }

         //deplacement de la famille + visibilite
        else if(data.isFamille()){
            this.famille.getPosition().setX(data.getArg1());
            this.famille.getPosition().setY(data.getArg2());
            if(data.getArg3() == Consts.VISIBLE)
                this.famille.setVisible(true);
            else
                this.famille.setVisible(false);
        }

        //trappes visibilite
        else if(data.isTrappe()){
           // System.out.println("trappe controller client "+ data.getArg3());
            if(data.getArg3() == Consts.VISIBLE)
                this.trappes.get(data.getObjet()).setVisible(true);
            else
                this.trappes.get(data.getObjet()).setVisible(false);
        }

        //score
        else if(data.isScore()){
            this.robot.getScoreRobot().setScore(data.getArg1());
        }

        //nombre de vie
        else if(data.isNbVies()){
            this.robot.setNbVies(data.getArg1());
        }

    }
    
    //quand on appuie sur une fleche ou espace
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)    kx = -1;
        if (key == KeyEvent.VK_RIGHT)   kx = 1;
        if (key == KeyEvent.VK_UP)      ky = 1;
        if (key == KeyEvent.VK_DOWN)    ky = -1; 
        if (key == KeyEvent.VK_SPACE)   kt = Consts.TIR;

        this.transmitKeys();

    }

//quand on relache la touche
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)    kx = 0;
        if (key == KeyEvent.VK_RIGHT)   kx = 0;
        if (key == KeyEvent.VK_UP)      ky = 0;
        if (key == KeyEvent.VK_DOWN)    ky = 0;
        if (key == KeyEvent.VK_SPACE)   kt = Consts.PASTIR;

        this.transmitKeys();
    }

    private void transmitKeys(){

        Donnees data = new Donnees(this.getEmetteur(),Consts.CLAVIER, 0 , kx, ky, kt);
        emission.push(data);

    }


}
