import java.awt.*;

class Projectile {
	// attributs

	private Position origine;
	private Position positionActuelle;
	private Etage etageCourant;
	private boolean touche; 
	private Image image;



	// accesseurs 

	// constructeur 


	public boolean touche(Monstre m)){
		if(this.positionActuelle.equals(m.positionActuelle)){
			this.setTouche(true);
		}
	}

	
}