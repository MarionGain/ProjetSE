import java.io.*;
import java.net.*;

class AccepterConnexion implements Runnable{
	private ServerSocket ss;
	private Socket socket = null;

	public Thread t1; 

	public AccepterConnexion(ServerSocket ss){
		this.ss = ss;
	}

	public void run (){
		
		try{
			while(true){
				socket = ss.accept();
				System.out.println("Un client se connecte");
				// truc à rajouter
				// t1.start();
			}
		}
		catch(IOException e){
			System.err.println("Erreur serveur");
		}
	}
}