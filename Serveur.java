import java.io.*;
import java.net.*;

public class Serveur{
	// public static void main (String args []){

	private ServerSocket ss = null; 
	private AccepterConnexion c;
	private int port = 80;
	private int nbClients;
	private int indiceClient;

	private Socket[] socketsClients;
	private BufferedReader[] tabIn; //Entrée Serveur <--- Clients
	private PrintWriter[] tabOut; //Sortie Serveur ---> Clients

	public Serveur(int port, int nbClients){
		
		try{
			this.ss = new ServerSocket(port);
			nbClients = nbClients;
			indiceClient = 0;

			socketsClients = new Socket[nbClients];

			tabIn = new BufferedReader[nbClients];
			tabOut = new PrintWriter[nbClients];
			// this.ss = new ServerSocket(port);
			// t = new Thread(new AccepterConnexion(ss));
			// this.t = new Thread();
			// this.t = new Thread(new AccepterConnexion(ss));
			System.out.println("Le serveur est à l'écoute du port " + ss.getLocalPort());
			c = new AccepterConnexion(ss,this);
			c.start();

		}
		catch(IOException e){
			System.err.println("Le port " + ss.getLocalPort()+ " est déjà utilisé !");
		}
		
	// }

	}
	//Add Client
	public void ajoutClient(Socket s) throws IOException
	{
		socketsClients[nbClients] = s;
		tabIn[nbClients] = new BufferedReader( new InputStreamReader(s.getInputStream()) );
		tabOut[nbClients] = new PrintWriter(s.getOutputStream());
		nbClients++;
		// t = true;
		System.out.println("Client ajouté");
	}


	public void communiquer(int indiceClient){
		tabOut[indiceClient].println("bla");
		tabOut[indiceClient].flush();
	}
}