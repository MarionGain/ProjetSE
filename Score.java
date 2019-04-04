import java.io.*;

class Score {

	// attributs
	private int score;
	private PrintWriter p;

	// constructeur par defaut		 
	public Score(){
		this.score = 0;
		try {
			this.p = new PrintWriter("score.txt");
		}

		catch(IOException e){
			e.printStackTrace();
		}
		
	}

	//	pas d'accesseur en ecriture on ne modifie pas le score manuellement 
	public int getScore(){
		return this.score;
	}

	// methodes d'ajout score 
	public void ajoutFamille(int niveau){
		int scoreFamille = 200; // exemple
		this.score = scoreFamille * niveau;

	}

	public void ajoutMonstre(int niveau){
		int scoreMonstre = 100; // exemple
		this.score = scoreMonstre * niveau; 
	}


    public void saveScore(String nom){
       String score = "" + this.getScore();
       p.write(nom + " : " + score+"\n");
       p.flush();

       
    }

}