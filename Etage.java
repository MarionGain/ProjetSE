class Etage {

	// attributs 
	private int id; // static ? 
	private CollectionAdversaires adversaires;
	private Famille famille;
	private Position position;

	// constructeur par defaut
	public Etage(){
		this.id = ; //
		this.CollectionAdversaires = null;
		this.famille = null;
		this.position = null;

	}

	// constructeur standard 
	public Etage(int id, CollectionAdversaires a, Famille f, Position p){
		this.id = id;
		this.adversaires = a;
		this.famille = f;
		this.position = p;
	}

	// accesseurs en lecture et ecriture
	private int getId (){
		return this.id;
	}

	private CollectionAdversaires getAdversaires(){
		return this.CollectionAdversaires;
	}

	private void setAdversaires(CollectionAdversaires c){
		this.adversaires = c;
	}

	private Famille getFamille(){
		return this.famille;
	}

	private void setFamille(Famille f){
		this.famille = f;
	}

	private Position getPosition(){
		return this.position;
	}

	private void setPosition(Position p){
		this.position = p;
	}

}