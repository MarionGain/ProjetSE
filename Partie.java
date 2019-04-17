import java.awt.*;
import java.util.Scanner;

class Partie {

	// attributs 

	// private Labyrinthe labyrinthe; 
	private CollectionRobots robots;
	private int robotCourant;
//	private int id;
	private boolean quitter;
	public static boolean partie; // une partie est creee
	private Scanner sc = new Scanner (System.in);
	private Serveur serveur = null;
	private Board board;


	// constructeur par defaut 

	public Partie(){
		// this.labyrinthe = null;
		this.robots = null;
		this.robotCourant = 0;
		this.quitter = false;
		this.partie = false;
		this.board = null;
	}

	public Partie(Board b){
		// this.labyrinthe = null;
		this.board = b;
		this.robots = null;
		this.robotCourant = 0;
		this.quitter = false;
		this.partie = false;
	}


	// public Partie(Labyrinthe l, CollectionRobots cr, int robot){
	// 	this.labyrinthe = l;
	// 	this.robots = cr;
	// 	this.robotCourant = robot;
	// 	this.quitter = false;
	// }

	// accesseur en lecture et ecriture

	// private int getRobotCourant(){
	// 	return this.robotCourant;
	// }

	// private Labyrinthe getLabyrinthe(){
	// 	return this.labyrinthe;
	// }

	// private CollectionRobots getRobots(){
	// 	return this.robots;
	// }

	// private void setLabyrinthe(Labyrinthe l){
	// 	this.labyrinthe = l;
	// }

	// private void setRobots(CollectionRobots cr){
	// 	this.robots = cr;
	// }

	// private void setRobotCourant(int robot){
	// 	this.robotCourant = robot;
	// }

	private Board getBoard(){
		return this.board;
	}
	private boolean getQuitter(){
		return this.quitter;
	}

	private void setQuitter(boolean quitter){
		this.quitter = quitter;
	}

	private boolean getPartie(){
		return this.partie;
	}

	private void setPartie(boolean p){
		 this.partie = p;
	}
	
	// Méthodes
	public void menu (){


		// while (!quitter){
			System.out.println("Bonjour ! Que souhaitez-vous faire ?\n1. Joueur en solo\n2. Joueur en mode multijoueurs\n3. Quitter");

			int choix1 = Integer.parseInt(sc.nextLine());// lire choix monsieur ;
			// int choix


			switch (choix1){
				case 1 : this.creationServeur(); this.creationClient(); 
				break;// création serveur + client 
				case 2 : this.multijoueurs(); break;
				case 3 : this.setQuitter(true); break;
				default : System.out.println("Ce choix est indisponible, veuillez réessayer");
			}

		// }
		// switch solo / multijoueurs 

		// switch multijoueurs : rejoindre/créer une partie (id pour une partie)

		// créer : switch mode coopératif/combat/collaboratif 

		// choix == rejoindre -> création d'un client 

		// quitter  

	}

	public void creationServeur(){
		 // this.serveur = new Serveur(80,1);
		 // serveur.communiquer(0);	
		System.out.println("Veuillez saisir un pseudo : ");
		String nom = sc.nextLine();
		Robot robot = new Robot(nom);
		this.getBoard().setRobot(robot);
		this.getBoard().setProjectile(new Projectile(robot));
		Thread ts = new Thread(new Serveur(2000, this.board.getRobot()));
		this.setPartie(true);
		ts.start();
		
	}

	public void creationClient(){
		// a checker
		System.out.println("Veuillez saisir l'adresse ip indiquée sur la machine de l'hôte"); // a modifier 
		Scanner sc = new Scanner(System.in); 
		String ip = sc.nextLine();
	
		Thread tc = new Thread(new Client(2000,ip,board));
		tc.start();

		

	}

	private void multijoueurs(){

		// while(!quitter){
			System.out.println("Vous avez sélectionné le mode multijoueurs. Comment souhaitez-vous jouer ?\n1. Rejoindre une partie\n2. Créer une nouvelle partie\n3. Retour au menu précédent\n 4.Quitter");

			// récupérer le choix 
			int choix = Integer.parseInt(sc.nextLine());// choix utilisateur 

			switch (choix) {
				case 1 : this.rejoindrePartie(); break;
				case 2 : this.mode(); break;
				case 3 : this.menu(); break;
				case 4 : this.setQuitter(true); break;
				default : System.out.println("Ce choix est indisponible, veuillez réessayer");
			}

		// }
		
	}

	public void rejoindrePartie(){
		System.out.println("Dans rejoindre partie");
		// if(this.getPartie() == true){ // il existe une partie 

			// rajouter fenetre choisir de rejoindre une partie;
			this.creationClient();
			//this.getBoard().getController().start();
		// } 
		// else {
		// 	System.out.println("Aucune partie n'est disponible, veuillez réessayer");
		// }

		
	}

	private void mode (){

		// while(!quitter){
			System.out.println("Vous avez sélectionné la création de partie. Quel mode de jeu souhaitez-vous utiliser ?\n1. Mode coopératif\n2. Mode collaboratif\n3. Mode combat\n4. Retourner au menu précédent\n5. Quitter");
			int choix = Integer.parseInt(sc.nextLine());// choix utilisateur 

			switch(choix){
				case 1 : this.modeCooperatif(); break;
				case 2 : this.modeCollaboratif(); break;
				case 3 : this.modeCombat(); break;
				case 4 : this.multijoueurs(); break;
				case 5 : this.setQuitter(true); break;
				default : System.out.println("Ce choix est indisponible, veuillez réessayer");
			}
		// }
	}

	private void modeCollaboratif(){

		this.creationServeur();
		this.creationClient();

	} 

	private void modeCooperatif(){

		this.creationServeur();
		this.creationClient();

	}

	private void modeCombat(){

		this.creationServeur();
		this.creationClient();

		// rajouter sécurité nombre de joueurs 

		// bouton lancer partie -> tant que le serveur n'a pas clique dessus, on attend 

	}

}