import javax.swing.JFrame;
import java.awt.EventQueue;

public class Drol extends JFrame{
    public Drol(){
        initUI();
    }

    public void initUI(){
        this.add(new Board());
        this.setResizable(false);
        this.setSize(1500,1000);

        this.setTitle("DROL");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String args[]){
        Drol drol = new Drol();
    }
}