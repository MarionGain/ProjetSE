import java.io.*;
import java.net.*;

public class Serveur implements Runnable{
	// public static void main (String args []){

	private ServerSocket ss = null; 
	private Thread t;
	// private int port = 2019;

	public Serveur(int port){
		
		try{
			this.ss = new ServerSocket(port);
			InetAddress adresse = InetAddress.getLocalHost();// "192.168.1.20";
			System.out.println("Veuillez communiquer cette adresse aux autres joueurs : " + adresse);
			// t = new Thread(new AccepterConnexion(ss));
			// this.t = new Thread();
			// this.t = new Thread(new AccepterConnexion(ss));
			System.out.println("Le serveur est à l'écoute du port " + ss.getLocalPort());
			

		}
		catch(IOException e){
			System.err.println("Le port " + ss.getLocalPort()+ " est déjà utilisé !");
		}

	}

	public void run(){
		t = new Thread(new AccepterConnexion(ss));
		t.start();
	}
}