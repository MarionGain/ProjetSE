import java.io.*;
import java.util.*;


class Classement{

    private ArrayList<Score> classement;
    private BufferedReader lecteur;
    private FileReader fr;
    private PrintWriter p;
    // private FileWriter fw;

    public Classement(){

    	this.classement = new ArrayList<Score>();
        try {
            this.fr = new FileReader("score.txt");
            this.p = new PrintWriter(new FileWriter("score.txt", true));
            this.lecteur = new BufferedReader(fr);
        }
        catch(IOException e){
          e.printStackTrace();
        }
    }

    public ArrayList<Score> getClassement(){
        return this.classement;
    }

    public void initClassement(){
    	
        String ligne = "";
    	try{
            this.fr = new FileReader("score.txt");
            this.lecteur = new BufferedReader(fr);
			ligne = lecteur.readLine();
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    
    	while(ligne != null){
    		try {

    			int i = ligne.indexOf(":");
                String nom = ligne.substring(0, i-1);
    			int s = Integer.parseInt(ligne.substring(i+2));
                Score score = new Score(s, nom);
                System.out.println(classement.size());
                //synchronized(classement){
                    classement.add(score);
                //}
    			
                System.out.println(classement.size());
    			ligne = lecteur.readLine();

    		}
    		catch(IOException e){
    			e.printStackTrace();
    		}
    		
    	}

    }


    public void ajoutScore(Score sc){
       
        String ligne = "";
        BufferedReader lecteur = null;
        FileReader fr;
        try{
            fr = new FileReader("score.txt");
            lecteur = new BufferedReader(fr);
            ligne = lecteur.readLine();         
        }
        catch(IOException e){
            e.printStackTrace();
        }
        if(ligne == null){
            classement.add(sc);
        }

        while(ligne != null){

            try {
                System.out.println(sc.getNom());
                int i = ligne.indexOf(":");
                
                String nom = ligne.substring(0, i-1);
                System.out.println("NOM : "+ nom);
                int s = Integer.parseInt(ligne.substring(i+2));
                // Score score = new Score(s, nom);

                int indice = this.exists(sc.getNom());
                System.out.println(indice);
                if(indice != -1){
                    this.classement.get(indice).setScore(sc.getScore());
                }
                else {
                    classement.add(sc);
                }

                ligne = lecteur.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }


    public void afficherClassement(){
        System.out.println("Début classement : ");
    	if(!this.classement.isEmpty()){
    		for(Score score : this.classement){

    			System.out.println(score);
    		}
    	}
        System.out.println("Fin classement : ");
    }

   // trie l'arrayList pour mettre les scores dans l'ordre
    public void updateClassement(){
    	
    	boolean trie = false;
    	int taille = this.classement.size();

    	while(!trie){
	
            trie = true;
            for(int i = 0; i < taille-1; i++){
                int score = this.classement.get(i).getScore();
                int scoreSuivant = this.classement.get(i+1).getScore();
                if(score > scoreSuivant){

                    Score temp = this.classement.get(i); 
                    this.classement.set(i, this.classement.get(i+1));
                    this.classement.set(i+1, temp);
                    trie = false;
                }
    	   }
            taille --;
    	}
        // afficherClassement();
        // this.sauvegardeFichier();
    }


    public int exists(String nom){
        int exists = -1;

        if(!this.classement.isEmpty()){
            for(int i = 0; i < this.classement.size(); i++){
               Score score = this.classement.get(i);
                // System.out.println(score);
                if(score.getNom().equals(nom)){
                    exists = i;
                    break;
                }
            }
        }

        return exists;

    }

    public void sauvegardeFichier(){
        this.updateClassement();
        try {
            File f = new File("score.txt");
            f.delete();
            this.p = new PrintWriter(new FileWriter("score.txt", true));
        }
        catch(IOException e){
            e.printStackTrace();
        }

        if(!this.classement.isEmpty()){
            for(Score score : this.classement){
                p.write(score.getNom() + " : " + score.getScore()+"\n");
                p.flush();
            }
        } 
    }   

}


