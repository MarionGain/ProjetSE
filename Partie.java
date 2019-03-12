class Partie {

	// attributs 

	private Labyrinthe labyrinthe; 
	private CollectionRobots robots;
	private int robotCourant;
//	private int id;
	private boolean quitter;
	private boolean partie; // une partie est creee


	// constructeur par defaut 

	public Partie(){
		this.labyrinthe = null;
		this.CollectionRobots = null;
		this.robotCourant = 0;
		this.quitter = false;
	}

	public Partie(Labyrinthe l, CollectionRobots cr, int robot){
		this.labyrinthe = l;
		this.robots = cr;
		this.robotCourant = robot;
		this.quitter = false;
	}

	// accesseur en lecture et ecriture

	private int getRobotCourant(){
		return this.robotCourant;
	}

	private Labyrinthe getLabyrinthe(){
		return this.labyrinthe;
	}

	private CollectionRobots getRobots(){
		return this.robots;
	}

	private void setLabyrinthe(Labyrinthe l){
		this.labyrinthe = l;
	}

	private void setRobots(CollectionRobots cr){
		this.robots = cr;
	}

	private void setRobotCourant(int robot){
		this.robotCourant = robot;
	}

	private boolean getQuitter(){
		return this.quitter;
	}

	private void setQuitter(boolean quitter){
		this.quitter = quitter;
	}

	
	// Méthodes
	private void menu (){


		while (!quitter){
			System.out.println("Bonjour ! Que souhaitez-vous faire ?\n1. Joueur en solo\n2. Joueur en mode multijoueurs\n3. Quitter");

			int choix1 = // lire choix monsieur ;
			int choix


			switch (choix1){
				case 1 : this.creationServeur(); this.creationClient(); break;// création serveur + client 
				case 2 : this.multijoueurs(); break;
				case 3 : this.setQuitter(true); break;
				default : System.out.println("Ce choix est indisponible, veuillez réessayer");
			}

		}
		// switch solo / multijoueurs 

		// switch multijoueurs : rejoindre/créer une partie (id pour une partie)

		// créer : switch mode coopératif/combat/collaboratif 

		// choix == rejoindre -> création d'un client 

		// quitter  

	}

	private void creationServeur(){

	}

	private void creationClient(){

	}

	private void multijoueurs(){

		while(!quitter){
			System.out.println("Vous avez sélectionné le mode multijoueurs. Comment souhaitez-vous jouer ?\n
				1. Rejoindre une partie\n2.Créer une nouvelle partie\n3. Retour au menu précédent\n4.Quitter");

			// récupérer le choix 
			int choix = // choix utilisateur 

			switch (choix) {
				case 1 : this.rejoindrePartie(); break;
				case 2 : this.mode(); break;
				case 3 : this.menu(); break;
				case 4 : this.setQuitter(true); break;
				default : System.out.println("Ce choix est indisponible, veuillez réessayer");
			}

		}
		
	}

	private void rejoindrePartie(){
		if(){ // il existe une partie 


		} 
	}

	private void mode (){

		while(!quitter){
			System.out.println("Vous avez sélectionné la création de partie. Quel mode de jeu souhaitez-vous utiliser ?\n
				1. Mode coopératif\n2.Mode collaboratif\n3. Mode combat\n4.Retourner au menu précédent\n5.Quitter");
			int choix = // choix utilisateur 

			switch(choix){
				case 1 : this.modeCooperatif(); break;
				case 2 : this.modeCollaboratif(); break;
				case 3 : this.modeCombat(); break;
				case 4 : this.multijoueurs(); break;
				case 5 : this.setQuitter(true); break;
				default : System.out.println("Ce choix est indisponible, veuillez réessayer");
			}
		}
	}

	private void modeCollaboratif(){

	} 

	private void modeCooperatif(){

	}

	private void modeCombat(){

	}

}