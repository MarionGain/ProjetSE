class Position {

	// attributs
	private double x;
	private double y;
	private Etage etage;

	// constructeur par defaut
	public Position (){
		this.x = 0;
		this.y = 0;
		this.etage = null;
	}

	// constructeur standard
	public Position(double x, double y, Etage e){
		this.x = x;
		this.y = y; 
		this.etage = e;
	}

	// accesseurs en lecture et ecriture
	private double getX(){
		return this.x;
	}

	private double getY(){
		return this.y;
	}

	private Etage getEtage(){
		return this.etage;
	}

	private void setX(double x){
		this.x = x;
	}

	private void setY(double y){
		this.y = y;
	}

	private void setEtage(Etage e){
		this.etage = e;
	}

}