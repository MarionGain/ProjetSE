import java.io.*;
import java.net.*;

class Client{

	public static Socket socket = null;
	public static Thread t1;

public static void main (String args []){
	// public Client(int port, InetAddress ip){
		
		// Socket socket = new Socket(adresse, port);
		int port = 80;
		try{
			InetAddress adresse = InetAddress.getLocalHost();// "192.168.1.20";
			Socket socket = new Socket(adresse,port); 
			//t1 = new Thread(new GestionDonneesClient(socket));
			System.out.println("Le client est connecté");
			// t1.start();
		}

		catch(UnknownHostException e){
			System.err.println("Impossible de se connecter à l'adresse : " + socket.getLocalAddress());
		}
		
		catch(IOException e){
			System.err.println("Aucun serveur à l'écoute du port " + socket.getLocalPort());
		}
		
		
	}

	// public void lancerClient(){

	// }
}