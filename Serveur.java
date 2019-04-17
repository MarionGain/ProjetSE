import java.io.*;
import java.net.*;

public class Serveur implements Runnable{
	// public static void main (String args []){

	private ServerSocket ss = null; 
	private Thread t;
	private int nbClient = 0;

	//pour mulit faire une liste de controllerServeur
	private ControllerServeur controllerServeur;
	private BoardServeur boardServeur;
	// private int port = 2019;

	public Serveur(int port, Robot r){
		
		try{
			this.ss = new ServerSocket(port);
			InetAddress adresse = InetAddress.getLocalHost();// "192.168.1.20";
			System.out.println("Veuillez communiquer cette adresse aux autres joueurs : " + adresse);
			System.out.println("Le serveur est à l'écoute du port " + ss.getLocalPort());
			boardServeur = new BoardServeur(r);
		}
		catch(IOException e){
			System.err.println("Le port " + ss.getLocalPort()+ " est déjà utilisé !");
		}

	}

	public void run(){
		try{
			while(true){
				Socket socket = ss.accept();
				System.out.println("Le client n° " + nbClient + " se connecte");
				nbClient++;
				//creation nouveau controller pour gerer client
				controllerServeur = new ControllerServeur(this.boardServeur,socket);

			}
		}
		catch(IOException e){
			System.err.println("Erreur serveur");
		}
	}

}