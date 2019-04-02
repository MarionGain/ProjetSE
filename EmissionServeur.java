import java.io.*;
import java.net.*;
import java.util.Scanner;

class EmissionServeur implements Runnable{
	
	private PrintWriter out;
	private Scanner sc;
	private String message = null;

	public EmissionServeur(PrintWriter out){
		this.out = out;
	}

	public void run(){

	sc = new Scanner(System.in);
		
		while(true){

			// System.out.println("Serveur votre message : ");
			// try{
			// 	Thread.sleep(20);
			// }
			// catch(InterruptedException e){
			// 	e.printStackTrace();
			// }
			try {
            Thread.currentThread().sleep(3000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }

			System.out.println("Serveur votre message :");
			//out.flush();
			message = sc.nextLine();
			//int test = 10;
			out.println(message);
			out.flush();
		}
	}
}