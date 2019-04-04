import java.io.*;
import java.net.*;

class GestionDonneesServeur implements Runnable{

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null; 
	private Thread emission, reception; 
	private Controller controller;

	public GestionDonneesServeur(Socket s, Board b){

		this.socket = s;
		this.controller = new Controller(b);
	}

	public void run(){
		try{
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Dans GestionDonneesServeur");

			emission = new Thread(new EmissionServeur(out,controller));
			reception = new Thread(new ReceptionServeur(in,controller));

			emission.start();
			reception.start();
		}
		
		catch(IOException e){
			System.err.println("Le serveur distant s'est déconnecté !");		
		}

		// t3 = new Thread(new EmissionServeur(out));
		// t4 = new Thread (new ReceptionServeur(in));

		// t3.start();
		// t4.start();
		
	}
}