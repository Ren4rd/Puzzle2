package parser;


import java.io.FileNotFoundException;

import puzzle.Board;
import puzzle.NineSquarePuzzle;

public class main {

	public static void main(String[] args) {
	 Parser scan = new Parser();
	 try {
		scan.reader("data1.txt");
		NineSquarePuzzle nSP = new NineSquarePuzzle("data7.txt"); {
			nSP.pool.pieceTab[0].affichage();
		}
		
		Board[] SO =nSP.megaSolverPuzzle(); {
			
			SO[0].plateauTab[0][0].affichage();
			
		}
		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	}
	
	
}
