package bataille;

public class Carte {



	private int couleur, valeur;
	
	
	private static String[] Couleurs = {"Coeur", "Carreau", "Pique", "Tréfle"};
	private static String[] Valeurs = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Roi", "Reine", "Valet", "Ace"};
	
	

	public Carte (int a, int b) {
		couleur = a; 
		valeur = b;
	}
	
	 public String toString() {
	    System.out.println(Valeurs[valeur] + Couleurs[couleur]);
		return Valeurs[valeur] + Couleurs[couleur]; 
	}
	
	
	public int getCouleur () {
		return couleur;
		
	}
	
	public int getValeurs () {
		return valeur;
		
	}
	
	
}
