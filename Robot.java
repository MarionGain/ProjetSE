import java.awt.Image;
import javax.swing.ImageIcon;

class Robot{
    private Position posOrigine;
    private Position posCourante;
    private Image imRobot;
    private ImageIcon i;

    public Robot(){
        loadImage();
        posOrigine = new Position(50,50);
        posCourante = new Position(50,50);
    }

    public void loadImage(){
        i = new ImageIcon("robot.png");
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
    
}