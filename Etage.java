import java.awt.*;

class Etage {

	// attributs 
	private int id;
	//private Famille famille;
	private Position position;

	// constructeur par defaut
	public Etage(){
		//this.id = ;
		//this.famille = null;
		this.position = null;

	}

	// constructeur standard 
	//a rajoute id et famille en parametre
	public Etage(int y){
		//this.id = id;
		//this.famille = f;
		this.position = new Position(0,y);
	}

	// accesseurs en lecture et ecriture
	public int getId (){
		return this.id;
	}

	// private Famille getFamille(){
	// 	return this.famille;
	// }

	// private void setFamille(Famille f){
	// 	this.famille = f;
	// }

	public Position getPosition(){
		return this.position;
	}

	public void setPosition(Position p){
		this.position = p;
	}

	public void doEtage(Graphics g, int x, int y, int largeur, int hauteur ){
		g.fillRect(x,y,largeur,hauteur);
	}


}