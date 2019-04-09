// classe joueurs
// implements runnable 

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

// extends Personnage
class Robot {

    private Position posOrigine;
    private Position posCourante;
    private Image imRobot;
    private ImageIcon i;
    private int nbVies = 3;   

    // Dorine ne les a pas 
    private Score score;
    private String nom;
    private int niveau;

    private boolean visible;
    private int x;
    private int y;
    private int direction;

    public Robot(){
        visible = true;
        loadImage();
        posOrigine = new Position(0,0);
        posCourante = new Position(0,0);
        direction = Consts.DROITE;

        this.score = new Score();
        this.nom = "";
        this.niveau = 1;
    }

    public void loadImage(){
            i = new ImageIcon("Images/Personnages/robotDroite.png");
            imRobot = i.getImage(); 
    }

    public Image getImage(){
        if(direction == Consts.GAUCHE){
            i = new ImageIcon("Images/Personnages/robotGauche.png");
            imRobot = i.getImage();
        }
        else{
            i = new ImageIcon("Images/Personnages/robotDroite.png");
            imRobot = i.getImage();
        }

        return this.imRobot;
    }

    public int getHeight(){
        return this.imRobot.getHeight(null);
    }

    public int getWidth(){
        return this.imRobot.getWidth(null);
    }

    public Position getPosition(){
        return posCourante;
    }

    public void setPosition(Position p){
        this.posCourante = p;
    }

    public Position getPositionOrigine(){
        return this.posOrigine;
    }

    public void setPositionOrigine(Position p){
        this.posOrigine = p;
    }

    public boolean isVisible(){
        return this.visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public int getNbVies(){
        return this.nbVies;
    }

    public void setNbVies(int nbv){
        this.nbVies = nbv;
    }

    public void vieEnMoins(){
        this.nbVies --;
    }

    public int getDirection(){
        return this.direction;
    }

    public void setDirection(int d){
        this.direction = d;
    }
    // Dorine ne les a pas 

    public Score getScore(){
        return this.score;
    }

    public void setScore(Score s){
        this.score = s;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public int getNiveau(){
        return this.niveau;
    }

    public void setNiveau(int niv){
        this.niveau = niv;
    }

    //retourne les "limitations" du rectangle de l image necessaire pour la collision
    //ajout ou retrait de pixel : pour eviter que le robot ne disparaisse avant qu il ne touche le monstre visuellement
    //dimension robot : 58*84
    public Rectangle getBounds() {
        return new Rectangle(this.getPosition().getX(), this.getPosition().getY()+10, this.getWidth(), this.getHeight()-20);
    }

    public Rectangle getBoundsTete(){
        return new Rectangle(this.getPosition().getX(), this.getPosition().getY()+5, this.getWidth(),5);
    }

    public Rectangle getBoundsPieds(){
        return new Rectangle(this.getPosition().getX(),this.getPosition().getY()+this.getHeight()-5,this.getWidth(),15);
    }
    
}