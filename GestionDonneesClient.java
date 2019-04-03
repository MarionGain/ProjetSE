import java.io.*;
import java.net.*;

class GestionDonneesClient implements Runnable{
	
	private Socket socket = null;;
	private PrintWriter out = null;
	private BufferedReader in = null; 
	private Thread emission, reception; 

	private Controller controller;


	public GestionDonneesClient(Socket s, Board b){

		this.socket = s;
		this.controller = new Controller(b);
	}

	public void run(){
		
		try{
			System.out.println("Bienvenue dans GestionDonneesClient");
			System.out.println(socket.toString());
			this.out = new PrintWriter(socket.getOutputStream());
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			emission = new Thread(new EmissionClient(out,controller));
			reception = new Thread(new ReceptionClient(in,controller));

			emission.start();
			reception.start();
			// System.out.println(in.readLine());
			// out.println("Bla");
			// out.flush();
			
		}
		
		catch(IOException e){
			System.err.println("Le serveur distant s'est déconnecté !");		
		}

		// t3 = new Thread(new EmissionClient(out));
		// t4 = new Thread (new ReceptionClient(in));

		// t3.start();
		// t4.start();
		
	}
}


			
