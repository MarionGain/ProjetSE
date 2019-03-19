import java.io.*;
import java.net.*;

class Client{

	public static Socket socket = null;
	public static Thread t1;

	public Client(int port, InetAddress ip){
		try{
			socket = new Socket(ip,port); 
			t1 = new Thread(new GestionDonneesClient(socket));
		}

		catch(UnknownHostException e){
			System.err.println("Impossible de se connecter à l'adresse : " + socket.getLocalAddress());
		}
		
		catch(IOException e){
			System.err.println("Aucun serveur à l'écoute du port " + socket.getLocalPort());
		}
		
		
	}

	public void lancerClient(){
		System.out.println("Le client est connecté");
		t1.start();
	}
}