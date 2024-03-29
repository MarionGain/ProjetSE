import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

// extends Personnage
class Monstre {
    private Position posOrigine;
    private Position posCourante;
    private Image imMonstre;
    private ImageIcon i;
    private Etage etage;
    private int direction;

    private int x;
    private boolean visible;

    public Monstre(Etage e, int x, int dir){
        this.etage = e;
        visible = true;
        loadImage();
        posOrigine = new Position(x,e.getPosition().getY()-this.getHeight());
        posCourante = new Position(x,e.getPosition().getY()-this.getHeight());
        this.direction = dir;
    }

    public void loadImage(){
        i = new ImageIcon("Images/Personnages/monstre.png");
        imMonstre = i.getImage(); 
    }

    public Image getImage(){
        return this.imMonstre;
    }

    public int getHeight(){
        return this.imMonstre.getHeight(null);
    }

    public int getWidth(){
        return this.imMonstre.getWidth(null);
    }

    public Position getPosition(){
        return posCourante;
    }

    public void setPosition(Position p){
        this.posCourante=p;
    }

    public boolean isVisible(){
        return this.visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public int getDirection(){
        return this.direction;
    }

    public void setDirection(int dir){
        this.direction=dir;
    }

    //Ajout
    //retourne les "limitations" du rectangle de l image, necessaire pour la collision
    //+12/-12 : pour eviter que le robot disparaisse avant d avoir touche visuellement le monstre
    //dimension monstre : 50*50
    public Rectangle getBounds() {
        return new Rectangle(this.getPosition().getX()+20, this.getPosition().getY()+5, this.getWidth()-40, this.getHeight());
    }
    
}