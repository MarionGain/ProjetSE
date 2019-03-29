//quand un client va appuyer sur une touche
//classe controller capte la demande
//l envoie au serveur sous forme d une commande( a voir)
//le serveur va modifier les caracteristique du perso et l envoyer a tout le monde y compris le client qui a "fait la demande",
// c est le serveur qui fait bouger le robot
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

class Controller {
    private int dx;
    private int dy;
    private Position p;
    private Robot robot;
    private Projectile projectile;
    private Board board;

    private int widthBoard = 1000;
    private int heightBoard = 480;
    
    private int projectileSpeed = 5;
    private boolean visible;
    private int zoneDeTir= 250; 
    private int directionTir=2; //1: gauche  2:droite
    private int recupDirectionTir;// appele dans tir pour eviter que le projectile change de direction quand on bouge en meme temps le robot


    public Controller(Board b){
        this.board = b;
        this.robot = b.getRobot();
        p = new Position((b.getB_Width()/2)-20,24+ b.getB_Height()/4);
        robot.setPositionOrigine(p);
        robot.setPosition(p);
        this.projectile = b.getProjectile();
    }

    public void move(){

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

    //ajout 3
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
    
    //quand on appuie sur une fleche ou espace
    public void keyPressed(KeyEvent e) {
        System.out.println("keypressed");

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
            directionTir = 1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
            directionTir = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
        //ajout 1
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
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }


}