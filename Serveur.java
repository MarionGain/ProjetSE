import java.io.*;
import java.net.*;

class Serveur {
	public static void main (String args []){


		// public static ServerSocket ss = null; 
		// public static Thread t;
		int port = 80;
		ServerSocket ss = null;
		// public Serveur(int port){
			try{
				ss = new ServerSocket(port);
				// this.ss = new ServerSocket(port);
				Thread t = new Thread(new AccepterConnexion(ss));
				t.start();
				// this.t = new Thread(new AccepterConnexion(ss));
			}
			catch(IOException e){
				System.err.println("Le port " + ss.getLocalPort()+ " est déjà utilisé !");
			}
			
		// }


		// public void lancerServeur(){
			
		// 		System.out.println("Le serveur est à l'écouter du port " + ss.getLocalPort());
		// 		t.start();
		// }
	}
}