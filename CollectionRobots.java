class CollectionRobots{

	// attributs 
	private Robot [] robots;
	private int nbRobots; 


	// constructeur par defaut

	public CollectionRobots (){
		this.robots = null;
		this.nbRobots = 0;
	}

	// constructeur standard

	public CollectionRobots (Robot [] r, int n){
		this.robots = r;
		this.nbRobots = n;
	}

	// accesseurs en lecture et ecriture

	private Robot[] getRobots(){
		return this.robots;
	}

	private Robot getRobot(int i){
		return this.robots[i];
	}

	private int getNbRobots(){
		return this.nbRobots;
	}

	private void setRobots(Robot [] r){
		this.robots = r;
	}

	private void setNbRobots(int n){
		this.nbRobots = n;
	}
}