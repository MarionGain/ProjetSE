//quand un client va appuyer sur une touche
//classe controller capte la demande
//l envoie au serveur sous forme d une commande( a voir)
//le serveur va modifier les caracteristique du perso et l envoyer a tout le monde y compris le client qui a "fait la demande",
// c est le serveur qui fait bouger le robot
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.List;


import java.io.*;
import java.net.*;


abstract class Controller {

    //probleme : update de controller client a une donnee en parametre
    public abstract void update(Donnees data);


}