import java.io.*;
import java.net.*;
import java.util.Scanner;

class EmissionServeur implements Runnable{

	private PrintWriter out;
	private Scanner sc;
	private String message = null;
	private Controller controller;

	public EmissionServeur(PrintWriter out, Controller c){
		this.out = out;
		this.controller = c;
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
	     	} 
	     	catch (InterruptedException e) {
	        	e.printStackTrace();
	     	}

	     	message = this.controller.getEmission();
         	if(message != null){

				//int test = 10;
				out.println(message);
				out.flush();
         	}
			// System.out.println("Serveur votre message :");
			// //out.flush();
			// 	message = sc.nextLine();
		}
	}
}