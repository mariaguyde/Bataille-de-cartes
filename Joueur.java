package batailleTest;

import java.util.ArrayList;

public class Joueur {
	
    // Attributs
	private String pseudo; 
	static int NombreJoueur; 
	public int pointsJoueur; 
	private ArrayList TableauCarte; 
	
	
	//Constructeur pour créer un joueur
	public Joueur (String pseudo,  ArrayList<Carte> Deckjoueur, int points) {
	
		this.pseudo = pseudo;
		this.TableauCarte = Deckjoueur;
		this.pointsJoueur = points;
		
		//incrémentation du nombre de joueur au cas où il y a plus de 2 joueurs
		NombreJoueur ++; 
	}

	// méthodes 
	public String getPseudo() {
		return pseudo;
	}
	
	
	//récupérer le nombre des points du joueur
	public int getPointsJoueur () {
		return pointsJoueur;
	}
	
	
}