import java.io.*;
import java.util.Scanner;

class EmissionClient implements Runnable{

	private PrintWriter out;
	private Scanner sc;
	private String message = null;
	private Controller controller;

	public EmissionClient(PrintWriter out, Controller c){
		this.out = out;
		this.controller = c;
	}

	public void run(){

	sc = new Scanner(System.in);
		
		while(true){ 
			// try {
   //          Thread.currentThread().sleep(2000);
   //       } catch (InterruptedException e) {
   //          e.printStackTrace();
   //       }
			message = this.controller.conversionDonneesString();

			if(message != null){
				System.out.println("Client votre message : ");
				// try{
				// 	Thread.sleep(20);
				// }
				// catch(InterruptedException e){
				// 	e.printStackTrace();
				// }
				//out.flush();
				//message = sc.nextLine();
				//int test = 10;
				out.println(message);
				out.flush();
			}
			
		}
	}
}