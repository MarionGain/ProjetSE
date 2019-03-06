class Labyrinthe extends Etage {

	//attributs

	private Etage [] etages;
	private int nbEtages; 

	// constructeur par defaut

	public Labyrinthe (){
		this.etages = null;
		this.nbEtages = 0;
	}

	// constructeur standard	
	public Labyrinthe (Etage [] etages, int n){
		this.etages = etages; 
		this.nbEtages = n;
	}

	// accesseurs en lecture et ecriture
	private Etage [] getEtages(){
		return this.etage;
	}

	private Etage getEtage (int i){
		return this.etages[i];
	}

	private int getNbEtages(){
		return this.nbEtages;
	}

	private void setEtages(Etage [] etages){
		this.etages = etages;
	}

	private void setNbEtages(int n){
		this.nbEtages = n;
	}

}