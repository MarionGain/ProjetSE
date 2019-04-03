import java.io.*;

class ReceptionServeur implements Runnable {
	// private String login =null; ???????
	private BufferedReader in; 
	private String message = null;

	public ReceptionServeur(BufferedReader in){ //paramètres String login 
		this.in = in;
		// this.login = login;
	}

	public void run(){
		while(true){
			
			try{
				message = in.readLine();
				// int i = 10;
				// System.out.println(i);
				// System.out.println("Bien recu");
				if(message != null)
				System.out.println("Le client dit "+message);
				// out.flush();	
			}
			catch(IOException e){
				System.err.println("Les données n'ont pas été réceptionnées correctement");
				e.printStackTrace();
			}
		}
		
	}
}