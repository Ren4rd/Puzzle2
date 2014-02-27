
package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import puzzle.Piece;

public class Parser {	
	
	public Parser() {
	}
	
	public Piece[] reader(String nomDuFichier) throws FileNotFoundException{
	Scanner scanner=new Scanner(new File(nomDuFichier));
	// on créée une liste de piece à partir du fichier texte
	List<Piece> listePiece = new ArrayList <Piece>() ;
	
	boolean estDansPremiereLigne=true;
	 while (scanner.hasNextLine()) {
		// On saute la première ligne
	    if (estDansPremiereLigne) { 
	    	estDansPremiereLigne=false;
	    	String line = scanner.nextLine();
	    	}
	    
	    else {
	    	String line = scanner.nextLine();
	    	String tabL[]=line.split("  | ");
	    	System.out.println("\n" + line);
	    	for (int k=0 ; k<tabL.length ; k++) {
	    	System.out.print(tabL[k] + " ");
	    	}
	    	int[] toto = {Integer.valueOf(tabL[1]),Integer.valueOf(tabL[2]),Integer.valueOf(tabL[3]),Integer.valueOf(tabL[4])};
	    	Piece p = new Piece(toto,tabL[0]);
	    	System.out.println("");
	    	p.affichage();
	    	listePiece.add(p);
	    }
	    

	 }
	Piece[] tabPiece = listePiece.toArray(new Piece[1]);
		//faites ici votre traitement
	
	
	 
	scanner.close();
	return tabPiece;
	}


}
