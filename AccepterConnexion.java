import java.io.*;
import java.net.*;

class AccepterConnexion extends Thread{

	private int nbClient = 1;	
	private ServerSocket ss;
	// private PrintWriter out = null;
	// private BufferedReader in = null; 


	public Thread t1; 

	public AccepterConnexion(ServerSocket ss){
		this.ss = ss;
	}



// public void run()
// 	{
// 		//Tant qu'il est ouvert
// 		while(true)
// 		{
// 			try 
// 			{
// 				// if(serveur.restePlace() )
// 				// {
// 				System.out.println("Client connecté");
// 				Socket socket = ss.accept();
// 				serveur.ajoutClient(socket);
					
// 				// }
// 			} 
// 			catch (IOException e)
// 			{
// 				e.printStackTrace();
// 			}
// 		}
// 		//
// 	}
	
	public void run (){
		
		try{
			while(true){
				Socket socket = ss.accept();
				System.out.println("Le client n° " + nbClient + " se connecte");
				nbClient++;
				t1 = new Thread(new GestionDonneesServeur(socket));
				// this.out = new PrintWriter(socket.getOutputStream());
				// this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// System.out.println(in.readLine());
			
				// truc à rajouter
				t1.start();
			}
		}
		catch(IOException e){
			System.err.println("Erreur serveur");
		}
	}
	
}