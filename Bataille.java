package batailleTest;

import java.util.ArrayList;

public class Bataille {

	public static void main(String[] args) {
		
		//Propriétés 
	    ArrayList<Carte>  Deck = new ArrayList<Carte>();
	    // Création des deux tableaux de cartes (paquets de cartes) des deux joueurs
    	// paquet du joueur 1, celui de Mario
    	ArrayList<Carte> DeckRandom = new ArrayList<Carte>();
    	//paquet du joueur 2, celui de Luigi
    	ArrayList<Carte> DeckRandom2 = new ArrayList<Carte>();
    	ArrayList<Carte> PiledeCarteEnCasdEgalite = new ArrayList<Carte>();
		boolean StatusEgalite = false; 
		int manche = 1; 
		
		
		//Message de bienvenue 
		System.out.println("ooooooooooooooooooooo Bienvenue à une nouvelle partie de Bataille ! ooooooooooooooooooooooooo");
		System.out.println(" \n"+""
				+ "                         _____\n"
				+ "                        |A .  | _____\n"
				+ "                        | /.\\ ||A ^  | _____\n"
				+ "                        |(_._)|| / \\ ||A _  | _____\n"
				+ "                        |  |  || \\ / || ( ) ||A_ _ |\n"
				+ "                        |____V||  .  ||(_'_)||( v )|\n"
				+ "                               |____V||  |  || \\ / |\n"
				+ "                                      |____V||  .  |\n"
				+ "                                             |____V|");
		
		
		// Initialisation du paquet de cartes en fonction du tableau contenant mes couleurs et les valeurs
		// afin d'avoir le nombre exact de cartes avec les différentes combinaisons possibles entre les couleurs et les valeurs 
    	for (int a=0; a< Carte.Couleurs.length; a++) {
    		for (int b=0; b< Carte.ValuesCarte.length; b++) {
    			Deck.add(new Carte(Carte.Couleurs[a], Carte.ValuesCarte[b]));
    		}
    	}

  	
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
		System.out.println("\n" + "\n" + "On a deux joueurs : " + joueur1.getPseudo() + " et " + joueur2.getPseudo());
		System.out.println("\n" +"===================================  C'est parti ! ==========================================");
		
		
		//Boucle du jeu 
		do {
	
		// Tirage d'une carte au hasard pour les deux joueurs 
		var carteJoueur1 = DeckRandom.get(0); 
		var CarteJoueur1Valeur = Carte.Valeurs[carteJoueur1.getValeur()];
		var carteJoueur1Indice = Carte.ValuesCarte[carteJoueur1.getValeur()]; 
		//System.out.println("valeurs joueur 1 "+CarteJoueur1Valeur);

		var carteJoueur2 = DeckRandom2.get(0);
		var CarteJoueur2Valeur = Carte.Valeurs[carteJoueur2.getValeur()];
		var carteJoueur2Indice = Carte.ValuesCarte[carteJoueur2.getValeur()];
		//System.out.println("valeurs joueur 2 "+CarteJoueur2Valeur);
		
		System.out.println("\n" + "===================================  Manche n° " + manche + "  ===========================================");
		System.out.println("\n" + "La carte de Mario est la suivante :  "+ CarteJoueur1Valeur);
		System.out.println("La carte de Luigi est la suivante :  " + CarteJoueur2Valeur);
		
		
		// Comparateur des valeurs des cartes pour définir qui est le vainqueur de la manche 
		if(carteJoueur2Indice > carteJoueur1Indice) {
			
			System.out.println("\n" +"*************** Résultats de la manche ****************");
			System.out.println("La carte de Luigi est plus grande !");
			
			//incrémentation du score du gagnant (joueur 2 : Luigi)
			joueur2.pointsJoueur++; 
			System.out.println("Le score de Mario est : " +joueur1.getPointsJoueur());
			System.out.println("Le score de Luigi est : " +joueur2.getPointsJoueur());
			
			//ajout de la carte du perdant au paquet du gagnant 
			DeckRandom2.add(carteJoueur1);
			//on retire la carte du perdant de son paquet de carte 
			DeckRandom.remove(carteJoueur1);
			DeckRandom2.remove(carteJoueur2);
			DeckRandom2.add(carteJoueur2);
			
			//System.out.println("taille du paquet du joueur 2 : "+DeckRandom2.size());
		   // System.out.println("taille du paquet du joueur 1 : "+DeckRandom.size());
			
		}
		else if(carteJoueur2Indice < carteJoueur1Indice) {
			System.out.println("\n" +"*************** Résultats de la manche ****************");
			System.out.println("La carte de Mario est plus grande !");
			joueur1.pointsJoueur++;
			System.out.println("le score de Mario est : " +joueur1.getPointsJoueur());
			System.out.println("Le score de Luigi est : " +joueur2.getPointsJoueur());
		
			DeckRandom2.remove(carteJoueur2);
			DeckRandom.add(carteJoueur2);
			DeckRandom.remove(carteJoueur1);
			DeckRandom.add(carteJoueur1);			
	
			//System.out.println("taille du paquet du joueur 2 : "+DeckRandom2.size());
			//System.out.println("taille du paquet du joueur 1 : "+DeckRandom.size());
		}
		
		// Cas : où il y a égalité c'est à dire que les deux cartes ont les mêmes valeurs
		else if (carteJoueur2Indice == carteJoueur1Indice){
			StatusEgalite = true;
			
			System.out.println("\n" + "              ==================  Il y a égalité ! =================");
			System.out.println("\n" +"On va refaire une nouvelle manche et on met en jeu les cartes précédentes des deux joueurs. ");
			
			PiledeCarteEnCasdEgalite.add(carteJoueur1);
			DeckRandom.remove(carteJoueur1);
			PiledeCarteEnCasdEgalite.add(carteJoueur2);
			DeckRandom2.remove(carteJoueur2);
			
			
			var nouvelleCarteJoueur1CasEgalite = DeckRandom.get(0); 
			var nouvelleCarteJoueur1Valeur = Carte.Valeurs[nouvelleCarteJoueur1CasEgalite.getValeur()];
			var nouvelleCarteJoueur1Indice = Carte.ValuesCarte[nouvelleCarteJoueur1CasEgalite.getValeur()]; 
			//System.out.println(nouvelleCarteJoueur1Valeur);
			
			var nouvelleCarteJoueur2CasEgalite = DeckRandom2.get(0);
			var nouvelleCarteJoueur2Valeur = Carte.Valeurs[nouvelleCarteJoueur2CasEgalite.getValeur()];
			var nouvelleCarteJoueur2Indice = Carte.ValuesCarte[nouvelleCarteJoueur2CasEgalite.getValeur()];
			//System.out.println(nouvelleCarteJoueur2Valeur);
			
			System.out.println("\n" + "La nouvelle carte de Mario est la suivante :  "+ nouvelleCarteJoueur1Valeur);
			System.out.println("La nouvelle carte de Luigi est la suivante :  " + nouvelleCarteJoueur2Valeur);
			
			if(nouvelleCarteJoueur2Indice > nouvelleCarteJoueur1Indice) {
				System.out.println("La carte de Luigi est plus grande !");
				System.out.println("\n" +"********** Résultats de la manche servant à départager les deux joueurs **********");
			
				PiledeCarteEnCasdEgalite.add(nouvelleCarteJoueur1CasEgalite);
				PiledeCarteEnCasdEgalite.add(nouvelleCarteJoueur2CasEgalite);
				DeckRandom2.remove(nouvelleCarteJoueur2CasEgalite);
				
				DeckRandom2.addAll(PiledeCarteEnCasdEgalite);
			
			   joueur2.pointsJoueur++;
			   System.out.println("Le score de Mario est : " +joueur1.getPointsJoueur());
			   System.out.println("Le score de Luigi est : " +joueur2.getPointsJoueur());
			   StatusEgalite = false;
			} 
			else if (nouvelleCarteJoueur2Indice < nouvelleCarteJoueur1Indice) {
				System.out.println("La carte de Mario est plus grande !");
				System.out.println("\n" +"********** Résultats de la manche servant à départager les deux joueurs **********");
		
				PiledeCarteEnCasdEgalite.add(nouvelleCarteJoueur1CasEgalite);
				PiledeCarteEnCasdEgalite.add(nouvelleCarteJoueur1CasEgalite);
				DeckRandom.remove(nouvelleCarteJoueur1CasEgalite);
				
				DeckRandom.addAll(PiledeCarteEnCasdEgalite);
				joueur1.pointsJoueur++;
				System.out.println("Le score de Mario est : " +joueur1.getPointsJoueur());
				System.out.println("Le score de Luigi est : " +joueur2.getPointsJoueur());
				StatusEgalite = false;
		
			}		
				
		 System.out.println("\n" + "============================================================================================");
		}
		
		//incrémentation du numéro de la manche 
		manche++;
		
		} while( manche < 11);
		/*------------- Si vous voulez ne pas limiter le nombre de parties, alors décommentez la ligne suivante ---------*/
		/*--- J'ai limité le nombre de tours car cela prend énormément de temps à finir une partie --*/
		// while( DeckRandom.size() > 0 || DeckRandom2.size()>0);
		
		
		//Définition des vainqueurs 
		int scoreJoueur1 = joueur1.pointsJoueur;
		int scoreJoueur2 = joueur2.pointsJoueur;
		
		if (scoreJoueur1 < scoreJoueur2) {
			System.out.println(" ");
			System.out.println("====================================  Résultats du jeu  ======================================");
			System.out.println("Le vainqueur est Luigi !");
			System.out.println("Luigi remporte la partie avec un score égale à " + joueur2.getPointsJoueur() + ".");
			
		
		} else if (scoreJoueur1 == scoreJoueur2) {
			// dans le cas, où l'on joue seulement 8 tours (while (tour < 8)), il se peut qu'il ait égalité, d'où cette condition 
			System.out.println(" ");
			System.out.println("====================================  Résultats du jeu  =======================================");
			System.out.println("Il y a égalité !");
		}
		else {
			System.out.println(" ");
			System.out.println("====================================  Résultats du jeu  =======================================");
			System.out.println("Le vainqueur est Mario !");
			System.out.println("Mario remporte la partie avec un score égale à " + joueur1.getPointsJoueur() + ".");
		}
		
		System.out.println("                          __        __  __            __      __ ___  __ \n"
				+ "                         |_ ||\\ |  |  \\|_   |   /\\   |__) /\\ |__) | ||_  \n"
				+ "                         |  || \\|  |__/|__  |__/--\\  |   /--\\| \\  | ||__ \n"
				+ "                                                                         ");
	}   
	
     	
}
