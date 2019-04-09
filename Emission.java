import java.io.*;
import java.net.*;

import java.util.Scanner;

class Emission /*implements Runnable*/{

    private PrintWriter out;
    private Controller controller;
    
    public Emission(Controller c,Socket s){

        try{
            this.out = new PrintWriter(s.getOutputStream());
            this.controller = c;

        }catch(IOException e){
            e.printStackTrace();
        }
       
	}

    public void push(Donnees data){
        String message = data.conversionDonneesString();
        out.println(message);
        out.flush();
    }
    // implémenter nouvelle méthode pour envoyer le classement directement sous forme de string

	// public void run(){

		
	// 	while(true){ 
    //         try{
    //             this.sleep(1);
    //         }catch(IOException e){
    //             e.printStackTrace();
    //         }

    //     }

			
	// }
}
