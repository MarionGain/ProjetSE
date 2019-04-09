import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.net.*;


class ControllerServeur extends Controller implements ActionListener {

    private Position p;
    private Robot robot;

    //etat des touches
    private int kx;
    private int ky;
    private int kt;

    private int emetteur;
    private Reception reception;
    private Emission emission;

    private Projectile projectile;
    private int projectileSpeed = 5;
    private int zoneDeTir = 250; 
    private int directionTir;
    private int recupDirectionTir;// appele dans tir pour eviter que le projectile change de direction quand on bouge en meme temps le robot

    private List<Monstre> monstres;
    private int avanceeMonstre = 0;

    private Famille famille;
    private int avanceeFamille = 0;

    private List<Etage> etages;
    private List<Trappe> trappes;

    private BoardServeur board;
    private int widthBoard = 1000;
    private int heightBoard = 480;


    private Timer timer;
    private int vitesse = 15;


    private Donnees donnees;
    private Classement classement;

    public ControllerServeur(BoardServeur b, Socket s){

        this.board = b;
        this.robot = b.getRobot();
        p = new Position((Consts.B_WIDTH/2)-20, 5+Consts.B_HEIGHT/4);
        robot.setPositionOrigine(p);
        robot.setPosition(p);
        
        this.projectile = b.getProjectile();
        this.directionTir = robot.getDirection();
        this.monstres = b.getListMonstres();
        this.famille = b.getFamille();

        this.etages = b.getListEtages();
        this.trappes = b.getListTrappes();

        this.donnees = null;
        this.classement = new Classement();
        this.classement.initClassement();
        
        this.reception = new Reception(this,s);
        this.emission = new Emission(this,s);
        reception.start();


        timer = new Timer(vitesse, this);
        timer.start();

    }

    public int getDirectionTir(){
        return this.directionTir;
    }

    public BoardServeur getBoard(){
        return this.board;
    }


    //recuperation des donnees
    public void update(Donnees data){
        if(data.isClavier()){
            kx = data.getArg1();
            ky = data.getArg2();
            kt = data.getArg3();
            if(kx == 1){
                directionTir = Consts.DROITE;
            }
            if(kx == -1){
                directionTir = Consts.GAUCHE;
            }
            if(kt == Consts.TIR){
                tir();
            }
        }
    }

    //mouvement du robot
    public void moveRobot(Position d){

        if(robot.getPosition().getY() <= 0 && d.getY() < 0){
            d.setY(0);
        }

        if(robot.getPosition().getY() >= heightBoard - robot.getHeight() && d.getY() > 0){
            d.setY(0);
        }

        p = new Position(robot.getPosition().getX() + d.getX(),robot.getPosition().getY() + d.getY());

        if(robot.getPosition().getX() > widthBoard + robot.getWidth()){
            p.setX(0 - robot.getWidth());
        }

        if(robot.getPosition().getX() < 0 - robot.getWidth()){
            p.setX(widthBoard + robot.getWidth());
        }

        robot.setPosition(p);
    }

    //mouvement des monstres
    public void moveMonstre(){
        for (int i = 0; i < monstres.size(); i++) {
            Monstre m = monstres.get(i);           
            // if (m.isVisible() == false) {
            //     monstres.remove(i);
            //     //System.out.println("monstre " + i + " tue");
            // }
        }

        for(Monstre monstre : monstres){

            if(monstre.getDirection() == 1){
                avanceeMonstre = -1;

            }
            if(monstre.getDirection() == 2){
                avanceeMonstre = 1;
            }

            p = new Position(monstre.getPosition().getX() + avanceeMonstre,monstre.getPosition().getY());

            if(monstre.getPosition().getX() > widthBoard + monstre.getWidth()){
                p.setX(0 - monstre.getWidth());
            }
    
            if(monstre.getPosition().getX() < 0 - monstre.getWidth()){
                p.setX(widthBoard+monstre.getWidth());
            }

            monstre.setPosition(p);
        }
    }

    //deplacement famille
    public void moveFamille(){
        if(famille.getDirection() == 1){
            avanceeFamille = -1;
        }

        if(famille.getDirection() == 2){
            avanceeFamille = 1;
        }

        p = new Position(famille.getPosition().getX() + avanceeFamille, famille.getPosition().getY());

        if(famille.getPosition().getX() > widthBoard + famille.getWidth()){
            p.setX(0 - famille.getWidth());
        }

        if(famille.getPosition().getX() < 0 - famille.getWidth()){
            p.setX(widthBoard + famille.getWidth());
        }

        famille.setPosition(p);

    }

    public void tir(){

        if(projectile.isVisible() == false){

            if(directionTir == Consts.DROITE){
                recupDirectionTir = 2;
            }

            if(directionTir == Consts.GAUCHE){
                recupDirectionTir = 1;
            }

            Position pos = new Position(robot.getPosition().getX(),robot.getPosition().getY() + (robot.getHeight()/2));
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
                p = new Position(projectile.getPosition().getX() - projectileSpeed,projectile.getPosition().getY());
                
                if (projectile.getPosition().getX() <  projectile.getPositionOrigine().getX() - zoneDeTir) {
                    projectile.setVisible(false);
                }

            } 
        }

        //quand joueur tir vers la droite
        if(recupDirectionTir == 2){
            if (projectile.isVisible()) {
                p = new Position(projectile.getPosition().getX() + projectileSpeed,projectile.getPosition().getY());
                
                if (projectile.getPosition().getX() > projectile.getPositionOrigine().getX() + zoneDeTir) {
                    projectile.setVisible(false);
                }

            } 
        }

        projectile.setPosition(p);
    } 

    //test de collision
    public void testCollision(Position d){ 

        for(Monstre monstre : monstres){
            if(monstre.isVisible()){
                Rectangle rRobot = robot.getBounds();
                Rectangle rMonstre = monstre.getBounds();
                //si un robot intersecte un monstre et que la position du robot est différent de sa position d'origine
                if(rMonstre.intersects(rRobot) && robot.getPosition().getX() != robot.getPositionOrigine().getX() && robot.getPosition().getY() != robot.getPositionOrigine().getY()){
                    robot.setPosition(robot.getPositionOrigine());
                    robot.vieEnMoins();
                    // if(robot.getVie()==0){
                    //     //condition pour remove le robot de la liste si sa vie est =0 et recuperation des scores
                            //Si tout le monde a une vie = 0 : on envoie une constante de fin, 
                            //on fait le classement et on envoie l arraylist du classement au client pour qu il l affiche 
                    

                    // code classement
                        // this.classement.ajoutScore(this.robot.getScore());
                        // this.classement.sauvegardeFichier();

                        // pour récupérer arrayList de Score
                    // this.classement.getClassement().get(i).getScore();

                    // affichage classement fin de jeu
                    // for(Score score : this.classement){
                    //     String s = score.toString();
                    //     // envoie string serveur
                    // }
             

                    // }

                    //System.out.println("collision robot monstre");
                } 
            }
        }

        if(projectile.isVisible() == true){
            Rectangle rProjectile = projectile.getBounds();
            
            for(Monstre monstre : monstres){
                if(monstre.isVisible()){
                    Rectangle rMonstre = monstre.getBounds();
                    if(rMonstre.intersects(rProjectile)){
                        monstre.setVisible(false);
                        projectile.setVisible(false);
            
                        robot.getScore().ajoutMonstre(robot.getNiveau());
                        //System.out.println(robot.getScoreRobot().getScore());
                        // System.out.println("collision projectile monstre");
                    }
                }
            }
        }

        if(famille.isVisible() == true){
            Rectangle rRobot = robot.getBounds();
            Rectangle rFamille = famille.getBounds();
            if(rRobot.intersects(rFamille)){
                famille.setVisible(false);
                robot.getScore().ajoutFamille(robot.getNiveau());
                //System.out.println("collision robot famille");
            }
        }

        int i = 0;
        //tant qu on a pas mis correctement move du robot
        for(Etage etage : etages){

            Rectangle rRobot = robot.getBounds();
            Rectangle rRobotTete = robot.getBoundsTete();
            Rectangle rRobotPieds = robot.getBoundsPieds();
            Rectangle rEtage = etage.getBounds();
            
            //test collision avec etage pour que le robot n aille pas plus bas
            if(rRobot.intersects(rEtage) && rRobotPieds.intersects(rEtage) && d.getY() > 0){
                d.setY(0);
            }
            //test collision avec etage pour que le robot n aille pas plus haut que le plafond
            else if(rRobot.intersects(rEtage) && !rRobotPieds.intersects(rEtage) && d.getY() < 0){
                d.setY(0);
            }

            if(etage.getListTrappes() != null){
                for(Trappe trappe : etage.getListTrappes()){           
                    Rectangle rTrappe = trappe.getBounds();
                    Rectangle rLeftTrappe = trappe.getBoundsLeft();
                    Rectangle rRightTrappe = trappe.getBoundsRight();

                    //collision horizontale trappe robot
                    if(trappe.isVisible()){
                        if(rRobotTete.intersects(rTrappe) && ky == 1 && !rRobotTete.intersects(rLeftTrappe) && !rRobotTete.intersects(rRightTrappe)){
                            trappe.setVisible(false);
                        }
                        if(rRobotPieds.intersects(rTrappe) && ky == -1 && !rRobotPieds.intersects(rLeftTrappe) && !rRobotPieds.intersects(rRightTrappe)){
                            trappe.setVisible(false);
                        }
                    }
                    else{
                        //collision laterale trappe robot
                       
                        if(rRobot.intersects(rLeftTrappe) && d.getX() < 0 ){                             
                            d.setX(0);
                            //System.out.println("collision cote gauche trappe");
                        }
                        if(rRobot.intersects(rRightTrappe) && d.getX() > 0){
                            d.setX(0);
                            //System.out.println("collision cote droite trappe");
                        }

                        //mouvement vertical robot
                        if(ky == 1) d.setY(-2);
                        else d.setY(2);

                        //test collision monstre trappe
                        for(Monstre monstre : monstres){
                            Rectangle rMonstre = monstre.getBounds();
                            if(rMonstre.intersects(rTrappe)){
                                if(monstre.getDirection() == 1){
                                    p = new Position(monstre.getPosition().getX() - avanceeMonstre,monstre.getPosition().getY());
                                }
                                if(monstre.getDirection() == 2){
                                    p = new Position(monstre.getPosition().getX() + avanceeMonstre,monstre.getPosition().getY());
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

    public void updateAll(){
        Position d = new Position();

        if(kx == 1){
            d.setX(2);
        }else if(kx == -1){
            d.setX(-2);
        }else{
            d.setX(0);
        }
        
        if(ky == 1){
            d.setY(-2);
        }else{
            d.setY(2);
        }

        testCollision(d);
        moveRobot(d);
        moveMonstre();
        updateProjectile();
        moveFamille();

        
        //envoi des donnees

        //en multi faire une liste robot
        //robots
        Donnees data = new Donnees(-1,Consts.ROBOT, -5 , this.robot.getPosition().getX(), this.robot.getPosition().getY(), 1);
        if(this.robot.isVisible()){
            data.setArg3(Consts.VISIBLE);
        }
        else{
            data.setArg3(Consts.PASVISIBLE);
        }
        emission.push(data);

        //en multi faire une liste projectile
        //projectiles
        data = new Donnees(-1,Consts.PROJECTILE, -5 , this.projectile.getPosition().getX(), this.projectile.getPosition().getY(),1);
        if(this.projectile.isVisible()){
            data.setArg3(Consts.VISIBLE);
        }
        else{
            data.setArg3(Consts.PASVISIBLE);
        }
        emission.push(data);


        //monstres
        for(int i = 0 ; i < this.monstres.size() ; i++){
            data = new Donnees(-1,Consts.MONSTRE, i, this.monstres.get(i).getPosition().getX(), this.monstres.get(i).getPosition().getY(),1);
            if(this.monstres.get(i).isVisible()){
                data.setArg3(Consts.VISIBLE);
            }
            else{
                data.setArg3(Consts.PASVISIBLE);
            }
            emission.push(data);
        }


        //famille
        data = new Donnees(-1,Consts.FAMILLE, -5 , this.famille.getPosition().getX(), this.famille.getPosition().getY(), 1);
        if(this.famille.isVisible()){
            data.setArg3(Consts.VISIBLE);
        }
        else{
            data.setArg3(Consts.PASVISIBLE);
        }
        emission.push(data);


        //trappes
        for(int i = 0 ; i < this.trappes.size() ; i++){
            data = new Donnees(-1,Consts.TRAPPE, i, this.trappes.get(i).getPosition().getX(), this.trappes.get(i).getPosition().getY(), 1);
            if(this.trappes.get(i).isVisible()){
                data.setArg3(Consts.VISIBLE);
            }
            else{
                data.setArg3(Consts.PASVISIBLE);
            }
            emission.push(data);
        }

        //score
        //quand multi en place on aura besoin d 'une liste de score attribue au robot
        data = new Donnees(-1,Consts.SCORE, 0, robot.getScoreRobot().getScore(),0,0);
        emission.push(data);

        //nombre de vie
        //quand multi en place on aura besoin d 'une liste de score attribue au robot
        data = new Donnees(-1, Consts.NBVIES, 0, robot.getNbVies(),0,0 );
        emission.push(data);
    }

    public void actionPerformed(ActionEvent evt){
        updateAll();
    }



}