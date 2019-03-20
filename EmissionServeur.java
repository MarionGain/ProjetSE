import java.io.*;

class Emission implements Runnable{
	private PrintWriter out;

	public Emission(PrintWriter out){
		this.out = out;
	}

	public void run(){


		while(true){


			// Envoie des donnees 
			out.flush();
		}
	}
}