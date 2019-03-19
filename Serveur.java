import java.io.*;
import java.net.*;

class Serveur {
	public static ServerSocket ss = null; 
	public static Thread t;

	public Serveur(int port){
		try{
			this.ss = new ServerSocket(port);
			this.t = new Thread(new AccepterConnexion(ss));
		}
		catch(IOException e){
			System.err.println("Le port " + ss.getLocalPort()+ " est déjà utilisé !");
		}
		
	}


	public void lancerServeur(){
		
			System.out.println("Le serveur est à l'écouter du port " + ss.getLocalPort());
			t.start();
	}
}