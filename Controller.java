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
    private int widthBoard = 1500;
    private int heightBoard = 1000;

    public Controller(Robot r){
        this.robot = r;
    }

    public void move(){
        p = new Position(robot.getPosition().getX()+dx,robot.getPosition().getY()+dy);

        if(robot.getPosition().getX() > widthBoard+robot.getWidth()){
            p.setX(0-robot.getWidth());
        }

        if(robot.getPosition().getX() < 0-robot.getWidth()){
            p.setX(widthBoard+robot.getWidth());
        }
        
        robot.setPosition(p);
    }

    //quand on appuie sur une fleche
    public void keyPressed(KeyEvent e) {
        System.out.println("keypressed");

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
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