import java.io.*;
import java.util.Scanner;

class ReceptionClient implements Runnable{
	// private String login =null; ???????
	private BufferedReader in; 
	private String message = null;
	private Controller controller;

	public ReceptionClient(BufferedReader in, Controller c){ //paramètres String login 
		this.in = in;
		this.controller = c;
		// this.login = login;
	}

	public void run(){
		while(true){
			 // try {
    //         Thread.currentThread().sleep(1000);
    //      } catch (InterruptedException e) {
    //         e.printStackTrace();
    //      }
			try{
				message = in.readLine();
				
				
				if(message != null){
					System.out.println("Le serveur dit " + message);
					this.controller.conversionStringDonnees(message);
				}
				// else {
				// 	System.out.println("pas de message");
				// }
			}
			catch(IOException e){
				System.err.println("Les données n'ont pas été réceptionnées correctement");
				e.printStackTrace();
			}
		}
	}
}