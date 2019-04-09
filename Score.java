import java.io.*;
import java.util.*;

class Score {

	// attributs
	private int score;
 	private String nom;

	// constructeur par defaut		 
	public Score(){
		this.score = 0;
	}

	// constructeur  
  	public Score(int score, String nom){

	    this.score = score;
	    this.nom = nom;
	}

	//	pas d'accesseur en ecriture on ne modifie pas le score manuellement 
	public int getScore(){
		return this.score;
	}

  	public void setScore(int s){
    	this.score = s;
  	}

  	public String getNom(){
    	return this.nom;
  	}
   	
   	public void setNom(String n){
    	this.nom = n;
  	}
	
	// methodes d'ajout score 
	public void ajoutFamille(int niveau){
		int scoreFamille = 200; // exemple
		this.score += scoreFamille * niveau;
	}

	public void ajoutMonstre(int niveau){
		int scoreMonstre = 100; // exemple
		this.score += scoreMonstre * niveau; 
	}

  	public String toString(){
	    String s = this.getNom() + " : " + this.getScore();
	    return s;
  	}
}
