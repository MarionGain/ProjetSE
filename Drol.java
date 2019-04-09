import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Drol extends JFrame{

    private Board b;
    private Classement classement;
    private FileWriter fichier; 

    public Drol(){
        
        initUI();

        try{
            this.fichier = new FileWriter("score.txt",true);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        this.classement = new Classement();

        this.classement.initClassement("score.txt");
        
    }

    public Board getBoard(){
        return this.b;
    }

    public Classement getClassement(){
        return this.classement;
    }

    public void initUI(){
        this.b = new Board();
        this.add(b);
        this.setResizable(false);
        //this.setSize(1500,1000);
        pack();


        this.setTitle("DROL");

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                    // ajouter saveScore
                // Drol.getBoard().getRobot().getScore().saveScore(Drol.getBoard().getRobot().getNom());
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String args[]){
        Drol drol = new Drol();

        
        Partie partie = new Partie(drol.getBoard()); // ajouter board 

        // // partie.creationServeur();
        //partie.menu();
        // drol.getBoard().getRobot().getScore().initScore();
        // System.out.println("bla");
        // drol.getBoard().getRobot().setNom("Marion");
        // drol.getBoard().getRobot().getScore().ajoutMonstre(10);
        // drol.getBoard().getRobot().getScore().saveScore(drol.getBoard().getRobot().getNom());
        // // drol.getBoard().getRobot().setNom("Laura");
        // drol.getBoard().getRobot().getScore().ajoutMonstre(100);
        // drol.getBoard().getRobot().getScore().saveScore("Laura");
        // drol.getBoard().getRobot().getScore().ajoutMonstre(19);
        // drol.getBoard().getRobot().getScore().saveScore(drol.getBoard().getRobot().getNom());
       
        // drol.getBoard().getRobot().getScore().ajoutMonstre(3);
        // drol.getBoard().getRobot().getScore().saveScore(drol.getBoard().getRobot().getNom());
        
        //  drol.getBoard().getRobot().getScore().ajoutMonstre(3);
        // drol.getBoard().getRobot().getScore().saveScore("Bla");
          


          // drol.getClassement().initClassement("score.txt");
           //drol.getBoard().getRobot().setNom("Marion");
           drol.getBoard().getRobot().getScore().setNom("Marion");
          drol.getBoard().getRobot().getScore().ajoutMonstre(3);
          drol.getClassement().ajoutScore(drol.getBoard().getRobot().getScore());
          drol.getBoard().getRobot().getScore().setNom("Laura");
           drol.getBoard().getRobot().setNom("Laura");
        // // drol.getBoard().getRobot().getScore().saveScore();

          drol.getBoard().getRobot().getScore().ajoutMonstre(90);
             drol.getClassement().ajoutScore(drol.getBoard().getRobot().getScore());
         
        // drol.getBoard().getRobot().getScore().saveScore("Blabla");
            drol.getBoard().getRobot().getScore().ajoutMonstre(40);
            drol.getClassement().ajoutScore(drol.getBoard().getRobot().getScore());
             drol.getClassement().sauvegardeFichier();
        // drol.getBoard().getRobot().getScore().saveScore("Paul");
        //   drol.getBoard().getRobot().getScore().ajoutMonstre(50);
        // drol.getBoard().getRobot().getScore().saveScore("Jean");
        // drol.getBoard().getRobot().getScore().initClassement("score.txt");
        // drol.getBoard().getRobot().getScore().ajoutMonstre(5);
        // drol.getBoard().getRobot().getScore().saveScore("Marc");
        // drol.getBoard().getRobot().getScore().ajoutMonstre(500);
        // drol.getBoard().getRobot().getScore().saveScore("Marc");
        // drol.classement.initClassement("score.txt");

        //drol.getBoard().getRobot().getScore().saveScore();
        // partie.creationClient();
        // partie.rejoindrePartie();
    }
}