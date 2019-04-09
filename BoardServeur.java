
import java.util.ArrayList;
import java.util.List;
class BoardServeur {

    private int choixFond;

    private Robot robot;
    private Projectile projectile;

    private List<Monstre> monstres;
    private Famille famille;

    private List<Trappe> trappes;
    private int largeurTrappe = 50;
    private int hauteurTrappe = 10;

    private List<Etage> etages;
    private int nbEtages = 4;

    private int posInitX ;
    private int posInitY ;

    private int posCouranteX;
    private int posCouranteY;




    public BoardServeur(){
        //choisir le fond pour l'envoyer au client
        int choixFond= (int)(Math.random()*23);

        robot = new Robot();
        projectile = new Projectile(robot);

        trappes = new ArrayList<Trappe>();

        etages = new ArrayList<Etage>();
        initEtages( etages);

        monstres = new ArrayList<Monstre>();
        initMonstres( monstres,etages);

        famille = new Famille(etages.get(3),0,2);


    }


    public void initEtages( List<Etage> etages){

        //creation liste trappes

        List<Trappe> trappes1 = new ArrayList<Trappe>();
        trappes1.add(new Trappe());
        trappes1.add(new Trappe());
        List<Trappe> trappes2 = new ArrayList<Trappe>();
        trappes2.add(new Trappe());
        List<Trappe> trappes3 = new ArrayList<Trappe>();
        trappes3.add(new Trappe());
        trappes3.add(new Trappe());

        trappes.addAll(trappes1);
        trappes.addAll(trappes2);
        trappes.addAll(trappes3);

        //creation des etage
        etages.add(new Etage(trappes1,Consts.B_HEIGHT-9 * (Consts.B_HEIGHT/16)-10));
        etages.add(new Etage(trappes2,Consts.B_HEIGHT-6* (Consts.B_HEIGHT/16)-10));
        etages.add(new Etage(trappes3,Consts.B_HEIGHT-3 * (Consts.B_HEIGHT/16)-10));
        etages.add(new Etage(Consts.B_HEIGHT-10));

        //attribution des positions aux trappes

        //etage 3
        Position p = new Position(80,etages.get(0).getPosition().getY());
        etages.get(0).getListTrappes().get(0).setPosition(p);
        Position p1 = new Position(Consts.B_WIDTH - (80+largeurTrappe),etages.get(0).getPosition().getY());
        etages.get(0).getListTrappes().get(1).setPosition(p1);

        //etage 2 
        Position p2 = new Position((Consts.B_WIDTH/2)-(largeurTrappe/2),etages.get(1).getPosition().getY());
        etages.get(1).getListTrappes().get(0).setPosition(p2);

        //etage 1
        Position p3 = new Position(80,etages.get(2).getPosition().getY());
        etages.get(2).getListTrappes().get(0).setPosition(p3);
        Position p4 = new Position(Consts.B_WIDTH - (80+largeurTrappe),etages.get(2).getPosition().getY());
        etages.get(2).getListTrappes().get(1).setPosition(p4);

    }

    public void initMonstres( List<Monstre> monstres, List<Etage> etages){

        monstres.add(new Monstre(etages.get(0),50,2));
        monstres.add(new Monstre(etages.get(0),Consts.B_WIDTH-80,1));
        monstres.add(new Monstre(etages.get(1),50,2));
        monstres.add(new Monstre(etages.get(1),Consts.B_WIDTH-80,1));
        monstres.add(new Monstre(etages.get(2),50,2));
        monstres.add(new Monstre(etages.get(2),Consts.B_WIDTH-80,1));
        monstres.add(new Monstre(etages.get(3),50,2));
        monstres.add(new Monstre(etages.get(3),Consts.B_WIDTH-100,1));
        monstres.add(new Monstre(etages.get(3),20,2));
        monstres.add(new Monstre(etages.get(3),Consts.B_WIDTH-50,1));
    }



    public Robot getRobot(){
        return this.robot;
    }

    public Projectile getProjectile(){
        return this.projectile;
    }

    public List<Monstre> getListMonstres(){
        return this.monstres;
    }

    public Famille getFamille(){
        return this.famille;
    }

    public List<Etage> getListEtages(){
        return this.etages;
    }

    public List<Trappe> getListTrappes(){
        return this.trappes;
    }
}