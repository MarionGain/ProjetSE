import java.util.ArrayList;
import java.util.List;

class Etage {

	// attributs 
	private int id;
	private Position position;
	private int width;
	private int height;
	private int B_width = 1000;
	private Trappe trappe;
	private List<Trappe> trappes;

	// constructeur par defaut
	public Etage(){
		this.trappes = null;
		this.position = null;
		this.width = B_width;
        this.height = 10;
	}

	// constructeur standard 
	//a rajoute id et famille en parametre
	public Etage(List<Trappe> trappes,int y){
		//this.id = id;
		this.trappes = trappes;
		this.position = new Position(0,y);
		this.width = B_width;
        this.height = 10;
	}

	public Etage(int y){
		this.trappes = null;
		this.position = new Position(0,y);
		this.width = B_width;
        this.height = 10;
	}

	// accesseurs en lecture et ecriture
	public int getId (){
		return this.id;
	}

	public Position getPosition(){
		return this.position;
	}

	public void setPosition(Position p){
		this.position = p;
	}

	public List<Trappe> getListTrappes(){
		return this.trappes;
	}

	public void doEtage(Graphics g, int x, int y, int largeur, int hauteur ){
		g.fillRect(x,y,largeur,hauteur);
	}

	public int getWidth(){
		return this.width;
	}

	public int getHeight(){
		return this.height;
	}

	public Rectangle getBounds(){
		return new Rectangle(this.getPosition().getX(), this.getPosition().getY(), this.getWidth(), this.getHeight());
	}


}