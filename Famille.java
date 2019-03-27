import java.awt.*;

class Famille {

	// attributs
	private boolean etat;
	private Position origine;
	private Position positionActuelle;
	private Image image;

	// constructeur par defaut
	public Famille(){
		this.etat = false;
		this.origine = null;
		this.positionActuelle = null;
	}

	// constructeur standard
	public Famille(boolean e, Position o, Position a){
		this.etat = e;
		this.origine = o;
		this.positionActuelle = a;
	}

	// accesseurs en lecture et ecriture
	private boolean getEtat() {
		return this.etat;
	}

	private Position getOrigine() {
		return this.origine;
	}

	private Position getPosition() {
		return this.positionActuelle;
	}

	private void setEtat(boolean e){
		this.etat = e;
	}

	private void setOrigine(Position o){
		this.origine = o;
	}

	private void setPosition(Position pa){
		this.positionActuelle = pa;
	}

}