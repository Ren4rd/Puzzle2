package puzzle;

import java.io.FileNotFoundException;
import java.util.Arrays;

import parser.Parser;




public class Pool {
	public Piece[] pieceTab;
	public boolean[] utiliseTab;
	int i=0;
	
	
	
	public Pool(String nomDuFichier) throws FileNotFoundException {
		Parser scan = new Parser();
		this.pieceTab = scan.reader(nomDuFichier);
		this.utiliseTab = new boolean[pieceTab.length];
		Arrays.fill(utiliseTab, false);
	}

	public void pieceDisponible(int n) {	
		this.utiliseTab[n]=false;
	}

	public boolean toutParfait(){
	while (pieceTab[i].parfait() && i< pieceTab.length){
		i++;
		}
	return(i==pieceTab.length);
	}

	public int getSizeBoard() {
		int s = (int) Math.sqrt(pieceTab.length);
		
		return s;
	}
	
	
		
		
		
		
		
}
