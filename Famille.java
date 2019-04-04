import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

class Famille{
    private Position posOrigine;
    private Position posCourante;
    private Image imFamille;
    private ImageIcon i;
    private Etage etage;
    private int direction;

    private int x;
    private boolean visible;

    public Famille(Etage e, int x, int dir){
        this.etage = e;
        visible = true;
        loadImage();
        posOrigine = new Position(x,e.getPosition().getY()-this.getHeight());
        posCourante = new Position(x,e.getPosition().getY()-this.getHeight());
        this.direction = dir;
    }

    public void loadImage(){
        i = new ImageIcon("Images/Personnages/fille.png");
        imFamille = i.getImage(); 
    }

    public Image getImage(){
        return this.imFamille;
    }

    public int getHeight(){
        return this.imFamille.getHeight(null);
    }

    public int getWidth(){
        return this.imFamille.getWidth(null);
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
    public Rectangle getBounds() {
        //+12/-12 : pour eviter que le robot disparaisse avant d avoir touche visuellement le monstre
        return new Rectangle(this.getPosition().getX()+18, this.getPosition().getY(), this.getWidth()-15, this.getHeight());
    }
}