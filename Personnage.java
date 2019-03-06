abstract class Personnage {
	
	// attributs
	private String nom;
	private int id; 
	private int nbVies;
	private Position origine;
	private Position positionCourante;

	// constructeur par defaut
	public abstract Personnage();
	
	// constructeur standard
	public abstract Personnage (String n, int id, int vies, Position o, Position pc);
	
	private void mouvement(){

	}

	private void tir(){

	}
}