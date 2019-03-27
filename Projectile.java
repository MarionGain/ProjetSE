import java.awt.Image;
import javax.swing.ImageIcon;

class Projectile{
    private Position posOrigine;
    private Position posCourante;
    private Image imProjectile;
    private ImageIcon i;

    public Projectile(){
        loadImage();
        posOrigine = new Position(50,50);
        posCourante = new Position(50,50);
    }

    public void loadImage(){
        i = new ImageIcon("projectile.png");
        imProjectile = i.getImage(); 
    }

    public Image getImage(){
        return this.imProjectile;
    }

    public int getHeight(){
        return this.imProjectile.getHeight(null);
    }

    public int getWidth(){
        return this.imProjectile.getWidth(null);
    }

    public Position getPosition(){
        return posCourante;
    }

    public void setPosition(Position p){
        this.posCourante=p;
    }
    

}