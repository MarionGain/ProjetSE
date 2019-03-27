import java.awt.*;

// classe joueurs
// implements runnable 

Class Robot extends Personnage implements ActionListener{

	// attributs 
	private int niveau;
	private Score score;

	// constructeur par defaut

	public Robot(){
		super();
		this.score = new Score(); // le constructeur par défaut de Score initialise l'entier à 0
		this.niveau = 0;
	}


	// constructeur standard

	public Robot (int niveau, Score score){
		super();
		this.niveau = niveau;
		this.score = score;

	}
	
	private void saut(){
		// touche espace 
		// modification de la position du robot 

	}

	private void tir(){
		// touche au choix 
		// New projectile 
		
	}

}