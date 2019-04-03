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

class Controller {

    private Position p;
    private Robot robot;
    private int dx;
    private int dy;
    private boolean descendre;
    private boolean monter;

    private Projectile projectile;
    private int projectileSpeed = 5;
    private int zoneDeTir= 250; 
    private int directionTir; //1: gauche  2:droite
    private int recupDirectionTir;// appele dans tir pour eviter que le projectile change de direction quand on bouge en meme temps le robot

    private Monstre monstre;
    private List<Monstre> monstres;
    private int avanceeMonstre=0;

    private Famille famille;
    private int avanceeFamille=0;

    private Etage etage;
    private List<Etage> etages;
    private Trappe trappe;
    private List<Trappe> trappes;

    private Board board;
    private int widthBoard = 1000;
    private int heightBoard = 480;

    public Controller(Board b){

        this.board = b;
        this.robot = b.getRobot();
        p = new Position((b.getB_Width()/2)-20, 5+b.getB_Height()/4);
        robot.setPositionOrigine(p);
        robot.setPosition(p);
        this.descendre = robot.getPassage();
        
        this.projectile = b.getProjectile();
        this.directionTir = robot.getDirection();
        this.monstre = b.getMonstre();
        this.monstres = b.getListMonstres();
        this.famille = b.getFamille();

        this.etage = b.getEtage();
        this.etages = b.getListEtages();
        this.trappe = b.getTrappe();
        this.trappes = b.getListTrappes();

    }

    //mouvement du robot
    public void moveRobot(){

        if(robot.getPosition().getY() <= 0 && dy<0){
            dy = 0;
        }

        if(robot.getPosition().getY() >= heightBoard-robot.getHeight() && dy > 0){
            dy = 0;
        }

        p = new Position(robot.getPosition().getX()+dx,robot.getPosition().getY()+dy);

        if(robot.getPosition().getX() > widthBoard+robot.getWidth()){
            p.setX(0-robot.getWidth());
        }

        if(robot.getPosition().getX() < 0-robot.getWidth()){
            p.setX(widthBoard+robot.getWidth());
        }

        robot.setPosition(p);
    }

    //verifier que le monstre est visible ou non
    public void updateMonstre(){
        for (int i = 0; i < monstres.size(); i++) {
            Monstre m = monstres.get(i);           
            if (m.isVisible() == false) {
                monstres.remove(i);
                System.out.println("monstre "+i+" tue");
            }
        }
    }

    //mouvement des monstres
    public void moveMonstre(){
        int i=0;
        for(Monstre monstre : monstres){

            if(monstres.get(i).getDirection()==1){
                avanceeMonstre = -1;

            }
            if(monstres.get(i).getDirection()==2){
                avanceeMonstre = 1;
            }

            p = new Position(monstres.get(i).getPosition().getX()+avanceeMonstre,monstres.get(i).getPosition().getY());

            if(monstres.get(i).getPosition().getX() > widthBoard+monstres.get(i).getWidth()){
                p.setX(0-monstres.get(i).getWidth());
            }
    
            if(monstres.get(i).getPosition().getX() < 0-monstres.get(i).getWidth()){
                p.setX(widthBoard+monstres.get(i).getWidth());
            }

            monstres.get(i).setPosition(p);
            i++;
        }
    }

    //deplacement famille
    public void moveFamille(){
        if(famille.getDirection()==1){
            avanceeFamille = -1;
        }

        if(famille.getDirection()==2){
            avanceeFamille = 1;
        }

        p = new Position(famille.getPosition().getX()+avanceeFamille, famille.getPosition().getY());

        if(famille.getPosition().getX() > widthBoard+famille.getWidth()){
            p.setX(0-famille.getWidth());
        }

        if(famille.getPosition().getX() < 0-famille.getWidth()){
            p.setX(widthBoard+famille.getWidth());
        }

        famille.setPosition(p);

    }

    public void tir(){
        if(projectile.isVisible() == false){

            if(directionTir == 2){
                recupDirectionTir=2;
            }

            if(directionTir == 1){
                recupDirectionTir=1;
            }

            Position pos = new Position(robot.getPosition().getX(),robot.getPosition().getY()+(robot.getHeight()/2));
            projectile.setPositionOrigine(pos);
            projectile.setPosition(pos);
            projectile.setVisible(true);
        }
    }

    //met a jour la position du projectile
    public void updateProjectile() {

        //quand joueur tir vers la gauche
        if(recupDirectionTir == 1){
            if (projectile.isVisible()) {
                p = new Position(projectile.getPosition().getX()-projectileSpeed,projectile.getPosition().getY());
                
                if (projectile.getPosition().getX() <  projectile.getPositionOrigine().getX()-zoneDeTir) {
                    projectile.setVisible(false);
                }

            } 
        }

        //quand joueur tir vers la droite
        if(recupDirectionTir == 2){
            if (projectile.isVisible()) {
                p = new Position(projectile.getPosition().getX()+projectileSpeed,projectile.getPosition().getY());
                
                if (projectile.getPosition().getX() > projectile.getPositionOrigine().getX()+zoneDeTir) {
                    projectile.setVisible(false);
                }

            } 
        }

        projectile.setPosition(p);
    } 

    //test de collision
    public void testCollision(){

        //a essayer: ne tester la collision que si le robot est visible 
        //implique d avoir un attribut 
        for(Monstre monstre : monstres){
            Rectangle rRobot = robot.getBounds();
            Rectangle rMonstre = monstre.getBounds();
                //condition bonne , probleme a l air de venir peut être de la dimension du robot
                if(rMonstre.intersects(rRobot) && robot.getPosition()!=robot.getPositionOrigine()){
                    robot.setPosition(robot.getPositionOrigine());
                    robot.vieEnMoins();
                    System.out.println("collision robot monstre");
                } 
            
            
        }

        if(projectile.isVisible()==true){
            Rectangle rProjectile = projectile.getBounds();
            
            for(Monstre monstre : monstres){
                Rectangle rMonstre = monstre.getBounds();
                if(rMonstre.intersects(rProjectile)){
                    monstre.setVisible(false);
                    projectile.setVisible(false);
                    System.out.println("collision projectile monstre");
                }
            }
        }

        if(famille.isVisible()==true){
            Rectangle rRobot = robot.getBounds();
            Rectangle rFamille = famille.getBounds();
            if(rRobot.intersects(rFamille)){
                famille.setVisible(false);
                System.out.println("collision robot famille");
            }
        }

        
        int i=0;
        //tant qu on a pas mis correctement move du robot
        for(Etage etage : etages){

            Rectangle rRobot = robot.getBounds();
            Rectangle rRobotTete = robot.getBoundsTete();
            Rectangle rRobotPieds = robot.getBoundsPieds();
            Rectangle rEtage = etage.getBounds();
            
            //test collision avec etage pour que le robot n aille pas plus bas
            if(rRobot.intersects(rEtage)  && rRobotPieds.intersects(rEtage) && dy>0){
                dy=0;
            }
            //test collision avec etage pour que le robot n aille pas plus haut que le plafond
            else if(rRobot.intersects(rEtage) && !rRobotPieds.intersects(rEtage) && dy<0){
                dy=0;
            }

            if(etage.getListTrappes() != null){
                for(Trappe trappe : etage.getListTrappes()){           
                    Rectangle rTrappe = trappe.getBounds();
                    
                    //collision horizontale trappe robot
                    if(trappe.isVisible()){
                        if(rRobotTete.intersects(rTrappe) && monter==true){
                            trappe.setVisible(false);
                        }
                        if(rRobotPieds.intersects(rTrappe) && robot.getPassage()==true){
                            trappe.setVisible(false);
                        }
                    }
                    else{
                        //collision laterale trappe robot
                        Rectangle rLeftTrappe = trappe.getBoundsLeft();
                        Rectangle rRightTrappe = trappe.getBoundsRight();
                        if(rRobot.intersects(rLeftTrappe) && dx<0 ){                             
                            dx=0;
                            System.out.println("collision cote gauche trappe");
                        }
                        if(rRobot.intersects(rRightTrappe) && dx>0){
                            dx=0;
                            System.out.println("collision cote droite trappe");
                        }

                        //mouvement vertical robot
                        if(monter == true) dy = -2;
                        else dy=2;

                        //test collision monstre trappe
                        for(Monstre monstre : monstres){
                            Rectangle rMonstre = monstre.getBounds();
                            if(rMonstre.intersects(rTrappe)){
                                if(monstre.getDirection()==1){
                                    p = new Position(monstre.getPosition().getX()-avanceeMonstre,monstre.getPosition().getY());
                                }
                                if(monstre.getDirection()==2){
                                    p = new Position(monstre.getPosition().getX()+avanceeMonstre,monstre.getPosition().getY());
                                }
                                monstre.setPosition(p);
                            }
                        }

                        if(!rRobot.intersects(rTrappe)){
                            trappe.setVisible(true);
                        }
                    }
                }
            }
        }

        i++;

    }
    
    //quand on appuie sur une fleche ou espace
    public void keyPressed(KeyEvent e) {
        System.out.println("keypressed");

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
            robot.setDirection(1);
            directionTir = 1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
            robot.setDirection(2);
            directionTir = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
            monter =true;
        }

        if (key == KeyEvent.VK_DOWN) {
            robot.setPassage(true);
            // for(Etage etage : etages){
            //     for(Trappe trappe : etage.getListTrappes()){
            //         if(trappe.isVisible()==false){
            //             dy = 2;
            //         }
            //     }
            // }

        }
        
        if (key == KeyEvent.VK_SPACE) {
            tir();
        }
    }

//quand on relache la touche
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 2;
            monter = false;
        }

        if (key == KeyEvent.VK_DOWN) {
            robot.setPassage(false);
        }
    }


}