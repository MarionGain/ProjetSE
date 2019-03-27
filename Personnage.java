import java.awt.*;

abstract class Personnage {
	
	// attributs
	private String nom;
	private int id; 
	private int nbVies;
	private Position origine;
	private Position positionCourante;
	private Image image;

	// constructeur par defaut
	public abstract Personnage();
	
	// constructeur standard
	public abstract Personnage (String n, int id, int vies, Position o, Position pc);
	
	private void mouvement(){
		// modification position x et eventuellement y si descente etage inferieur trappe 
	}


}