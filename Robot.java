import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

class Robot{
    private Position posOrigine;
    private Position posCourante;
    private Image imRobot;
    private ImageIcon i;
    private int nbVies = 3;

    private boolean visible;
    private int x;
    private int y;

    public Robot(){
        visible = true;
        loadImage();
        posOrigine = new Position(0,0);
        posCourante = new Position(0,0);
    }

    public void loadImage(){
        i = new ImageIcon("Images/Personnages/robot.png");
        imRobot = i.getImage(); 
    }

    public Image getImage(){
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
        this.posCourante=p;
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

    public void vieEnMoins(){
        this.nbVies --;
    }

    //retourne les "limitations" du rectangle de l image necessaire pour la collision
    //+8/-5 : pour eviter que le robot ne disparaisse avant qu il ne touche le monstre visuellement
    public Rectangle getBounds() {
        return new Rectangle(this.getPosition().getX()+8, this.getPosition().getY(), this.getWidth()-5, this.getHeight());
    }
    
}