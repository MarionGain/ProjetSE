class Consts {
	public static final int port = 2019;
	public static final int nbViesMax = 3; 
	public static final int B_WIDTH = 1000;
	public static final int B_HEIGHT = 480;



	// Direction mouvements

	public static final int HAUT = 1;
	public static final int BAS = 2;
	public static final int GAUCHE = 3;
	public static final int DROITE = 4;
	public static final int DIRECTION1 = 1;
	public static final int DIRECTION2 = 2; 


	//numero de emetteur

	public static final int SERVEUR = -1;
	public static final int EMETTEUR1 = 1;
	public static final int EMETTEUR2 = 2;
	public static final int EMETTEUR3 = 3;
	public static final int EMETTEUR4 = 4;


	//type d objet

	public static final int INT = 1;
	public static final int BOOLEAN = 2;

	public static final int ROBOT = 3; // 1: le joueur envoie son deplacement au serveur 2:le serveur envoie aux clients le deplacement d un robot qu il a recu
	public static final int PROJECTILE = 4; //le serveur envoie au joueur la position du projectile d un robot
	public static final int MONSTRE = 5;  // le serveur gere le deplacement des monstres et envoie leur mouvements aux joueurs
	public static final int FAMILLE = 6;  // le serveur gere le deplacement des familles et envoie leur mouvements aux joueurs

	public static final int FOND = 9;  //serveur envoie au debut du jeu les donnees pour le fond

	public static final int JOUEUR1 = 10; //serveur envoie position de depart du joueur a tous les clients
	public static final int JOUEUR2 = 11; //serveur envoie position de depart du joueur a tous les clients
	public static final int JOUEUR3 = 12; //serveur envoie position de depart du joueur a tous les clients
	public static final int JOUEUR4 = 13; //serveur envoie position de depart du joueur a tous les clients


//on essaye d envoyer que des positions ainsi, chaque controller client va calculer tout seul si un robot reviens au point de depart, si il est mort, si un monstre est mort etc.
//cours de partie

	//action Robot

	public static final int DEPLACEMENT = 1;
	public static final int TIR = 2;


	//action Projectile

	
	public static final int DIRECTIONTIR =2;


//initialisation du plateau

	//action Fond

	public static final int FONDALEATOIRE = 1;


	//position Joueurs

	public static final int POSITIONXJ1 = 50;
	public static final int POSITIONETAGEJ1 = 0;

	public static final int POSITIONXJ2 = B_WIDTH - 60;
	public static final int POSITIONETAGEJ2 = 0;

	public static final int POSITIONXJ3 = 50;
	public static final int POSITIONETAGEJ3 = 1;

	public static final int POSITIONXJ4 = B_WIDTH - 60;
	public static final int POSITIONETAGEJ4 = 1;
	

	//positions et directions monstres
	public static final int POSITIONX1 = B_WIDTH/2 + 20;
	public static final int POSITIONETAGE1 = 0;

	public static final int POSITIONX2 = B_WIDTH/2 -20;
	public static final int POSITIONETAGE2 = 0;
	
	public static final int POSITIONX3 = B_WIDTH/2 + 20;
	public static final int POSITIONETAGE3 = 1;

	public static final int POSITIONX4 = B_WIDTH/2 -20;
	public static final int POSITIONETAGE4 = 1;

	public static final int POSITIONX5 = B_WIDTH/2 + 20;
	public static final int POSITIONETAGE5 = 2;

	public static final int POSITIONX6 = B_WIDTH/2 -20;
	public static final int POSITIONETAGE6 = 2;

	public static final int POSITIONX7 = B_WIDTH/2 + 20;
	public static final int POSITIONETAGE7 = 3;

	public static final int POSITIONX8 = B_WIDTH/2 -20;
	public static final int POSITIONETAGE8 = 3;


	public static final int POSITIONX9 = B_WIDTH/2 + 40;
	public static final int POSITIONETAGE9 = 3;

	
	public static final int POSITIONX10 = B_WIDTH/2 -40;
	public static final int POSITIONETAGE10 = 3;



	//position Famille
	public static final int POSITIONFX = 0;
	public static final int POSITIONETAGEF = 3;



//fin de partie

	//score
	public static final int SCORE = 3; //a voir si c est une action du robot.. 
	


	// Transfert donnees

	public static final String DEBUTCHAINE = "S";
	public static final String SEPARCHAINE = "-";


}