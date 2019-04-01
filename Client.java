import java.io.*;
import java.net.*;

public class Client implements Runnable{

	private Socket socket = null;
	private Thread t1;
	// private PrintWriter out = null;
	// private BufferedReader in = null; 
	// int port = 80;
	private String ip = "192.168.1.20";

	public Client(int port, String ip){
	
		try{

			// InetAddress adresse = InetAddress.getLocalHost();// "192.168.1.20";
			this.socket = new Socket(ip,port); 
			// this.out = new PrintWriter(socket.getOutputStream());
			// this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}

		catch(UnknownHostException e){
			System.err.println("Impossible de se connecter à l'adresse : " + socket.getLocalAddress());
		}
		
		catch(IOException e){
			System.err.println("Aucun serveur à l'écoute du port " + socket.getLocalPort());
		}
		
		
	}

	public void run(){
 		t1 = new Thread(new GestionDonneesClient(socket));
 		// try{
 		// 	System.out.println(in.readLine());
 		// }
 		// catch(IOException e){
 		// 	e.printStackTrace();
 		// }
		System.out.println("Le client est connecté");

		t1.start();
	}
}