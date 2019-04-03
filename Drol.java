import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Drol extends JFrame{

    public Drol(){
        initUI();
    }

    public void initUI(){
        this.add(new Board());
        this.setResizable(false);
        //this.setSize(1500,1000);
        pack();

        this.setTitle("DROL");

        // a rajouter
        this. addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //Do what you want when the window is closing.
                System.out.println("youhouuuuuu");
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    

    public static void main(String args[]){
        Drol drol = new Drol();
    }
}