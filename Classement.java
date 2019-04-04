import java.io.*;
import java.util.*;


class Classement{

    private ArrayList<String> classement;
    private BufferedReader lecteur;
    private FileReader fr;

    public Classement(){
    	this.classement = new ArrayList<String>();
    }

    public void initClassement(String fichier){
    	String score = "";
    	try{
    		fr = new FileReader(fichier);
    		lecteur = new BufferedReader(fr);
			score = lecteur.readLine();
    		
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    
    	while(score != null){
    		try {
    			System.out.println(score);
    			int i = score.indexOf(":");
    			String s = score.substring(i+2);
    			classement.add(s);
    		//	System.out.println(s);
    			score = lecteur.readLine();

    		}
    		catch(IOException e){
    			e.printStackTrace();
    		}
    		
    	}
    	this.afficherClassement();
    	this.updateClassement();
    	this.afficherClassement();

    }

    public void afficherClassement(){
    	if(!this.classement.isEmpty()){
    		for(String score : this.classement){
    			System.out.println(score);
    		}
    	}
    }




   // trie l'arrayList pour mettre les scores dans l'ordre
    public void updateClassement(){
    	
    	boolean trie = false;
    	int i = 0;

    	while(!trie && i < this.classement.size()-1){
			System.out.println(this.classement.size());
    		int score = Integer.parseInt(this.classement.get(i));
    		// System.out.println(score);
    		int scoreSuivant = Integer.parseInt(this.classement.get(i+1));
			if(score > scoreSuivant){
    			String temp = this.classement.get(i); 
    			this.classement.set(i, this.classement.get(i+1));
    			this.classement.set(i+1, temp);
    			trie = false;
    		}
    		i++;
    	}
    }
}