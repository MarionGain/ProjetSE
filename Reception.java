import java.io.*;
import java.net.*;

import java.util.Scanner;

class Reception extends Thread/*implements Runnable*/{
    // private String login =null; ???????
    private BufferedReader in;
    private Controller controller;

    public Reception(Controller c, Socket s){ //paramètres String login
            try{
                this.in = new BufferedReader (new InputStreamReader (s.getInputStream()));;
                this.controller = c;
                // this.login = login;
            }catch(IOException e){
                System.err.println("Les données n'ont pas été réceptionnées correctement");
                e.printStackTrace();
            }
    }

    public void run(){

        while(true){

            try{
                //avec readLine on sais qu on est arrivee a la fin de la chaine , il cherche "\n"
                String message = in.readLine();
                if(message != null){
                        //System.out.println("Le serveur dit " + message);
                        Donnees data = new Donnees();
                        data = data.conversionStringDonnees(message);
                        this.controller.update(data);
                }
            }
            catch(IOException e){
                    System.err.println("Les données n'ont pas été réceptionnées correctement");
                    e.printStackTrace();
            }
        }
    }
}
