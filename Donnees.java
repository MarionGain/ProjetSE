import java.util.*;

class Donnees {

	private int emetteur;
	private int type;	
	private int objet;	//indice
	private int arg1;	//position x       //pour score : score
	private int arg2;	//position y
	private int arg3;	//visible  //pour le clavier : si tir ou pastir
	//private ArrayList<String> donnees;


	public Donnees (int emetteur,int type, int objet, int arg1, int arg2, int arg3) {

		this.emetteur = emetteur;
		this.type = type;
		this.objet = objet;
		this.arg1 = arg1;	
		this.arg2 = arg2;	
		this.arg3 = arg3;	

	}

	public Donnees(){
		this.emetteur = -2;
		this.type = -2;
		this.objet = -2;
	}

	public int getEmetteur(){
		return this.emetteur;
	}

	public int getType(){
		return this.type;
	}

	public int getObjet(){
		return this.objet;
	}

	public int getArg1(){
		return this.arg1;
	}

	public int getArg2(){
		return this.arg2;
	}

	public int getArg3(){
		return this.arg3;
	}

	public void setArg3(int visible){
		this.arg3 = visible;
	}

	public String conversionDonneesString(){
		
		String s = Consts.DEBUTCHAINE + String.valueOf(this.emetteur) + Consts.SEPARCHAINE + String.valueOf(this.type) + Consts.SEPARCHAINE + String.valueOf(this.objet) + Consts.SEPARCHAINE + String.valueOf(this.arg1) + Consts.SEPARCHAINE + String.valueOf(this.arg2) + Consts.SEPARCHAINE + String.valueOf(this.arg3) + Consts.FINCHAINE ;
		return s;
	}

        public Donnees conversionStringDonnees(String s){
			//System.out.println("chaine conversion stringdonnees "+ s);

            Donnees data = new Donnees();
            s = s.replaceAll(Consts.DEBUTCHAINE , "");
            s = s.replaceAll(Consts.FINCHAINE , "");
            if(s.equals("") == false){
                String [] d = s.split(Consts.SEPARCHAINE);
                data = new Donnees(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]), Integer.parseInt(d[3]), Integer.parseInt(d[4]), Integer.parseInt(d[5]));
            }

            return data;
	}

        public boolean isRobot(){
			if(this.type == Consts.ROBOT ) return true;
			else return false;
		}

		
		public boolean isProjectile(){
			if(this.type == Consts.PROJECTILE) return true;
			else return false;
		}
		
		public boolean isMonstre(){
			if(this.type == Consts.MONSTRE) return true;
			else return false;
		}
		
		public boolean isFamille(){
			if(this.type == Consts.FAMILLE) return true;
			else return false;
		}
		
		public boolean isFond(){
			if(this.type == Consts.FOND) return true;
			else return false;
		}
		
		public boolean isTrappe(){
			if(this.type == Consts.TRAPPE) return true;
			else return false;
		}

		public boolean isClavier(){
			if(this.type == Consts.CLAVIER) return true;
			else return false;
		}

		public boolean isScore(){
			if(this.type == Consts.SCORE) return true;
			else return false;
		}

		public boolean isNbVies(){
			if(this.type == Consts.NBVIES) return true;
			else return false;
		}

}
