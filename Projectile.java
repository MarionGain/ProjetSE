import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

class Projectile{
    private Position posOrigine;
    private Position posCourante;
    private Image imProjectile;
    private ImageIcon i;
    private Robot robot;
    
    private boolean visible;

    public Projectile(Robot r){
        this.robot = r;
        visible = false;
        loadImage();
        posOrigine = new Position(robot.getPosition().getX(),robot.getPosition().getX()+(robot.getHeight()/2));
        posCourante = new Position(robot.getPosition().getX(),robot.getPosition().getX()+(robot.getHeight()/2));
    }

    public void loadImage(){
        i = new ImageIcon("Images/Personnages/projectile.png");
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
        this.posCourante = p;
    }

    public Position getPositionOrigine(){
        return this.posOrigine;
    }

    public void setPositionOrigine(Position p){
        this.posOrigine = p;
    }

    public void setVisible(boolean b){
        this.visible = b;
    }

    public boolean isVisible(){
        return this.visible;
    }

    //Ajout
    //retourne les "limitations" du rectangle de l image necessaire pour la collision
    public Rectangle getBounds() {
        return new Rectangle(this.getPosition().getX(), this.getPosition().getY(), this.getWidth(), this.getHeight());
    }
}