package batailleTest;

import java.util.ArrayList;

public class Bataille {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Message de bienvenue 
		System.out.println("*********  Bienvenue à une nouvelle partie de Bataille !  *********");
		System.out.println(" \n"+""
				+ "          _____\n"
				+ "         |A .  | _____\n"
				+ "         | /.\\ ||A ^  | _____\n"
				+ "         |(_._)|| / \\ ||A _  | _____\n"
				+ "         |  |  || \\ / || ( ) ||A_ _ |\n"
				+ "         |____V||  .  ||(_'_)||( v )|\n"
				+ "                |____V||  |  || \\ / |\n"
				+ "                       |____V||  .  |\n"
				+ "                              |____V|");
		
		
		// Initialisation du paquet de cartes
	    ArrayList<Carte>  Deck = new ArrayList<Carte>();
    	for (int a=0; a< Carte.Couleurs.length; a++) {
    		for (int b=0; b< Carte.ValuesCarte.length; b++) {
    			Deck.add(new Carte(Carte.Couleurs[a], Carte.ValuesCarte[b]));
    			//System.out.println(Carte.Valeurs[b] + Carte.Couleurs[a]);
    		}
    	}
    	
    	
        // Création des deux tableaux de cartes (paquets de cartes) des deux joueurs
    	// paquet du joueur 1, celui de Mario
    	ArrayList<Carte> DeckRandom = new ArrayList<Carte>();
    	//paquet du joueur 2, celui de Luigi
    	ArrayList<Carte> DeckRandom2 = new ArrayList<Carte>();
    	
    	
    	
    	//Division du paquet de cartes en deux et on le mélange 
    	while (Deck.size() > 0) {
    		int sizeDeckNew = Deck.size() - 1;
    		int carteIndex = (int) Math.round(sizeDeckNew*Math.random()); 
    		 
    		if (DeckRandom.size() < Deck.size()) {
    			var carteAdd = Deck.get(carteIndex); 
    			DeckRandom.add(carteAdd); 
    			Deck.remove(carteAdd);
    			//System.out.println(DeckRandom.size());
    		} 
    		else {
    			var carteAdd = Deck.get(carteIndex); 
    			DeckRandom2.add(carteAdd); 
    			Deck.remove(carteAdd);
    			//System.out.println(DeckRandom2.size());
    		}    		
    	}
    	
    	
    	
    	//Création des deux joueurs
		Joueur joueur1 = new Joueur ("Mario", DeckRandom, 0); 
		Joueur joueur2 = new Joueur ("Luigi", DeckRandom2, 0);
		
		
		
		System.out.println("\n" + "On a deux joueurs :");
		System.out.println(joueur1.getPseudo() + " et " + joueur2.getPseudo());
	
		
		System.out.println("LETS GO !!!!!");
		
		int tour = 0; 
		
		//Boucle de jeu 
		do {
			
		// Valeurs des cartes
		var carteJoueur1 = DeckRandom.get(1); 
		var CarteJoueur1Valeur = Carte.Valeurs[carteJoueur1.getValeur()];
		var carteJoueur1Indice = Carte.ValuesCarte[carteJoueur1.getValeur()]; 
		//System.out.println(CarteJoueur1Valeur);
		//System.out.println(carteJoueur1Indice);
		
		var carteJoueur2 = DeckRandom2.get(0);
		var CarteJoueur2Valeur = Carte.Valeurs[carteJoueur2.getValeur()];
		var carteJoueur2Indice = Carte.ValuesCarte[carteJoueur2.getValeur()];
		//System.out.println(CarteJoueur2Valeur);
		//System.out.println(carteJoueur2Indice);
		
		
		System.out.println(" ");
		System.out.println("La carte de Mario est la suivante :  "+ CarteJoueur1Valeur);
		System.out.println("La carte de Luigi est la suivante :  " + CarteJoueur2Valeur);
		
		tour++;
		
		
		// Comparateur des valeurs des cartes
		if(carteJoueur2.getValeur() > carteJoueur1.getValeur()) {
			System.out.println(" ");
			System.out.println("********** Résultats **********");
			System.out.println("La carte de Luigi est plus grande !");
			
			//incrémentation du score 
			joueur2.pointsJoueur++; 
			System.out.println("le score de Mario est : " +joueur1.getPointsJoueur());
			System.out.println("Le score de Luigi est : " +joueur2.getPointsJoueur());
			
			//ajout de la carte au paquet du perdant donc Mario 
			DeckRandom.add(carteJoueur2);
			//retire la carte du paquet de jeu du gagnant donc de Luigi
			DeckRandom2.remove(carteJoueur2);
			
			//System.out.println("taille du paquet du joueur 2 : "+DeckRandom2.size());
			//System.out.println("taille du paquet du joueur 1 : "+DeckRandom.size());
			
			
		}
		else if(carteJoueur2.getValeur() < carteJoueur1.getValeur()) {
			System.out.println(" ");
			System.out.println("********** Résultats **********");
			System.out.println("La carte de Mario est plus grande !");
			joueur1.pointsJoueur++;
			System.out.println("le score de Mario est : " +joueur1.getPointsJoueur());
			System.out.println("Le score de Luigi est : " +joueur2.getPointsJoueur());
			
		
			DeckRandom2.add(carteJoueur1);
			DeckRandom.remove(carteJoueur1);
			
			//System.out.println("taille du paquet du joueur 2 : "+DeckRandom2.size());
			//System.out.println("taille du paquet du joueur 1 : "+DeckRandom.size());
		}
		
		else {
			System.out.println("Il y a égalité ! ");
		}
		
		} while( tour < 8);
		/*------------- Si vous voulez ne pas limiter le nombre de parties, alors décommentez la ligne suivante ---------*/
		/*--- J'ai limité le nombre de tours car cela prend énormément de temps à finir une partie --*/
		// while( DeckRandom.size() > 0 || DeckRandom2.size()>0);
		
		
		//Définition des vainqueurs 
		int scoreJoueur1 = joueur1.pointsJoueur;
		int scoreJoueur2 = joueur2.pointsJoueur;
		
		if (scoreJoueur1 < scoreJoueur2) {
			
			System.out.println(" ");
			System.out.println("=========== Résultats de la partie ==========");
			System.out.println("Le vainqueur est Luigi !");
			System.out.println("Luigi remporte la partie avec un score égale à " + joueur2.getPointsJoueur());
		} else {
			System.out.println(" ");
			System.out.println("=========== Résultats de la partie ==========");
			System.out.println("Le vainqueur est Mario !");
			System.out.println("Mario remporte la partie avec un score égale à " + joueur1.getPointsJoueur());
		}
		
		System.out.println(" __        __  __            __      __ ___  __ \n"
				+ "|_ ||\\ |  |  \\|_   |   /\\   |__) /\\ |__) | ||_  \n"
				+ "|  || \\|  |__/|__  |__/--\\  |   /--\\| \\  | ||__ \n"
				+ "                                                ");
	}   
	
     	
}
