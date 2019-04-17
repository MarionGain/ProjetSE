import java.awt.Image;
import javax.swing.ImageIcon;

class FondDrol{
    private Image imFond;
    private ImageIcon i;

    private String nomFond;

    public FondDrol(String nf){
        this.nomFond = nf;
        loadImage(nomFond);
    }

    public void loadImage(String nomFond){
        i = new ImageIcon(nomFond);
        imFond = i.getImage(); 
    }

    public Image getImage(){
        return this.imFond;
    }

    public String getNomFond(){
        return this.nomFond;
    }

    public void setNomFond(String nf){
        this.nomFond = nf;
    }

}