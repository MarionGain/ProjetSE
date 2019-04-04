import java.awt.*;

class Trappe{
    private Position position;
    private boolean visible;
    private int width;
    private int height;

    public Trappe(){
        this.position = null;
        this.visible = true;
        this.width = 110;
        this.height = 10;
    }

    public Position getPosition(){
        return this.position;
    }

    public void setPosition(Position p){
        this.position = p;
    }

    public boolean isVisible(){
        return this.visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void doTrappe(Graphics g, int x, int y){
		g.fillRect(x,y,this.width,this.height);
    }

    public Rectangle getBounds(){
        return new Rectangle(this.getPosition().getX(), this.getPosition().getY(), this.getWidth(), this.getHeight());
    }

    public Rectangle getBoundsLeft(){
        return new Rectangle(this.getPosition().getX()-30,this.getPosition().getY(),30,this.getHeight());
    }

    public Rectangle getBoundsRight(){
        return new Rectangle(this.getPosition().getX()+this.getWidth(),this.getPosition().getY(),30,this.getHeight());
    }
}