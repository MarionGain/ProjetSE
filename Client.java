import java.io.*;
import java.net.*;

public class Client implements Runnable{

	private Socket socket;
	private Thread t1;
	private Board board;
    private Controller control;
	// private PrintWriter out = null;
	// private BufferedReader in = null; 
	// int port = 80;
	// private String ip = "192.168.1.20";

	public Client(int port, String ip, Board b){
		
		this.board = b;

		try{

			this.socket = new Socket(ip,port); 
			ControllerClient controllerClient = new ControllerClient(this.board,this.socket);
			board.setController(controllerClient);
			
		}

		catch(UnknownHostException e){
			System.err.println("Impossible de se connecter à l'adresse : " + socket.getLocalAddress());
		}
		
		catch(IOException e){
			System.err.println("Aucun serveur à l'écoute du port " + socket.getLocalPort());
		}	
		
	}

	public void run(){
 		//t1 = new Thread(new GestionDonneesClient(socket, board));
 		// try{
 		// 	System.out.println(in.readLine());
 		// }
 		// catch(IOException e){
 		// 	e.printStackTrace();
 		// }
		System.out.println("Le client est connecté");
		System.out.println("Client Robot : " + this.board.getRobot().getNom() + " score : " + this.board.getRobot().getScoreRobot().getScore());

		//t1.start();
	}
}
