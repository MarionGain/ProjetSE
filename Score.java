class Score {

	// attributs
	private int score;

	// constructeur par defaut		 
	public Score(){
		this.score = 0;
	}

	//	pas d'accesseur en ecriture on ne modifie pas le score manuellement 
	private int getScore(){
		return this.score;
	}

	// methodes d'ajout score 
	private void ajoutFamille(int niveau){
		int scoreFamille = 200; // exemple
		this.score = scoreFamille * niveau;

	}

	private void ajoutMonstre(int niveau){
		int scoreMonstre = 100; // exemple
		this.score = scoreMonstre * niveau; 
	}

}