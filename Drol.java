import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Drol extends JFrame{

    private Board b;
    private Classement classement;

    public Drol(){
        initUI();
        this.classement = new Classement();

    }

    public Board getBoard(){
        return this.b;
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
        System.out.println("bla");
        drol.getBoard().getRobot().setNom("Marion");
        drol.getBoard().getRobot().getScore().ajoutMonstre(10);
        drol.getBoard().getRobot().getScore().saveScore(drol.getBoard().getRobot().getNom());
        drol.getBoard().getRobot().getScore().ajoutMonstre(100);
        drol.getBoard().getRobot().getScore().saveScore(drol.getBoard().getRobot().getNom());
        drol.getBoard().getRobot().getScore().ajoutMonstre(19);
        drol.getBoard().getRobot().getScore().saveScore(drol.getBoard().getRobot().getNom());
        drol.getBoard().getRobot().getScore().ajoutMonstre(3);
        drol.getBoard().getRobot().getScore().saveScore(drol.getBoard().getRobot().getNom());
         drol.classement.initClassement("score.txt");
        //drol.getBoard().getRobot().getScore().saveScore();
        // partie.creationClient();
        // partie.rejoindrePartie();
    }
}