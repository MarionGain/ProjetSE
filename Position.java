import java.awt.event.KeyEvent;

class Position {

	// attributs
	private int x;
	private int y;

	//private Etage etage;

	// constructeur par defaut
	public Position (){
		this.x = 0;
		this.y = 0;
        
		//this.etage = null;
	}

	// constructeur standard
    //!!!!!!!!! a rajoute quand ca seras bon un parametre etage !!!!!!!
	public Position(int x, int y){
		this.x = x;
		this.y = y; 
		//this.etage = e;
	}

	// accesseurs en lecture et ecriture
	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	// private Etage getEtage(){
	// 	return this.etage;
	// }

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	// private void setEtage(Etage e){
	// 	this.etage = e;
	// }


}