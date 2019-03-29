import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

class Monstre{
    private Position posOrigine;
    private Position posCourante;
    private Image imMonstre;
    private ImageIcon i;

    private int x;
    private int y;

    public Monstre(){
        loadImage();
        posOrigine = new Position(50,50);
        posCourante = new Position(50,50);
    }

    public void loadImage(){
        i = new ImageIcon("monstre.png");
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


    //Ajout
    //retourne les "limitations" du rectangle de l image, necessaire pour la collision
    public Rectangle getBounds() {
        return new Rectangle(this.getPosition().getX(), this.getPosition().getY(), this.getWidth(), this.getHeight());
    }
    
}