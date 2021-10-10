package batailleTest;

public class Carte {

	// attributs
	private String couleur;
	private int valeur; 
	
	// tableau avec les différentes valeurs et les couleurs des cartes
	public static String[] Couleurs = {"Coeur", "Carreau", "Pique", "Tréfle"};
	public static String[] Valeurs = {"2", "3", "4", "5", "6", "7", "8", "9", "10","Valet", "Reine", "Roi", "As"};
	//valeur des cartes afin de pouvoir comparer les cartes et de déterminer quelle est la plus grande carte
	public static int[] ValuesCarte = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	    
   
	// Constructeur pour créer une carte 
	public Carte (String a, int b) {
		couleur = a; 
		valeur = b;
	}
	
	
	//méthodes 
	public String getCouleur () {
		return couleur;
	}
	
	public int getValeur () {
		return valeur;
	}
  
	
} 
