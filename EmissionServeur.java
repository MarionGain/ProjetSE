import java.io.*;

class EmissionServeur implements Runnable{
	private PrintWriter out;

	public EmissionServeur(PrintWriter out){
		this.out = out;
	}

	public void run(){


		while(true){


			// Envoie des donnees 
			out.flush();
		}
	}
}