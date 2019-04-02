import javax.swing.JFrame;
import java.awt.EventQueue;

public class Drol extends JFrame{

    private Board b;

    public Drol(){
        initUI();
    }

    public void initUI(){
        this.b = new Board();
        this.add(b);
        this.setResizable(false);
        //this.setSize(1500,1000);
        pack();

        this.setTitle("DROL");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Board getBoard(){
        return this.b;
    }

    public static void main(String args[]){
        Drol drol = new Drol();

        Partie partie = new Partie(drol.getBoard()); // ajouter board 

        // partie.creationServeur();
        partie.menu();
        System.out.println("bla");
        // partie.creationClient();
        // partie.rejoindrePartie();
    }
}