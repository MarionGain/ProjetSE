class CollectionAdversaires{

	// attributs 
	private Monstre [] monstres;
	private int nbMonstres; 


	// constructeur par defaut

	public CollectionAdversaires (){
		this.monstres = null;
		this.nbMonstres = 0;
	}

	// constructeur standard

	public CollectionAdversaires (Monstre [] m, int n){
		this.monstres = m;
		this.nbMonstres = n;
	}

	// accesseurs en lecture et ecriture

	private Monstre[] getMonstres(){
		return this.monstres;
	}

	private Monstre getMonstre(int i){
		return this.monstres[i];
	}

	private int getNbMonstres(){
		return this.nbMonstres;
	}

	private void setMonstres(Monstre [] m){
		this.monstres = m;
	}

	private void setNbMonstres(int n){
		this.nbMonstres = n;
	}
}