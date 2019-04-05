import java.util.*;

class Donnees {

	private int emetteur;
	private int type;
	private int objet;
	private int action;
	private int deplacement;
	//private ArrayList<String> donnees;

	public Donnees (int emetteur, int objet, int action, int deplacement) {

		this.emetteur = emetteur;
		this.type = type;
		this.objet = objet;
		this.action = action;
		this.deplacement = deplacement;
	}

	public Donnees(){
		this.emetteur = -2;
		this.type = -2;
		this.objet = -2;
		this.action = -2;
		this.deplacement = -2;
	}

	public String conversionDonneesString(){
		
		String s = "";
		s += Consts.DEBUTCHAINE + this.emetteur + Consts.SEPARCHAINE + this.type + Consts.SEPARCHAINE + this.objet + Consts.SEPARCHAINE + this.action + Consts.SEPARCHAINE + this.deplacement;
		return s;
	}

	public ArrayList<Donnees> conversionStringDonnees(String s){
		
		ArrayList<Donnees> donnees = new ArrayList<Donnees>();
		if (s.equals("") == false){
			String[] tabString = s.split(Consts.DEBUTCHAINE);
			for (String a : tabString){
				if(a.equals("") == false){
					String [] d = a.split(Consts.SEPARCHAINE);
					Donnees data = null;
					if(d.length == 3){
						data = new Donnees(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]), -1);
					}
				
					else if(d.length == 4){
						data = new Donnees(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]), Integer.parseInt(d[3]));
					}
					donnees.add(data);				
				}
			}
		}

		return donnees;
	}

}