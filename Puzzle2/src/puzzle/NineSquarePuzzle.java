package puzzle;
import java.io.FileNotFoundException;

import java.util.Arrays;

import puzzle.Pool;


public class NineSquarePuzzle {
	static int nbSolutions = 0;
    public Pool pool;
	
    
    
	public NineSquarePuzzle(String fileName) {
		try {
			this.pool = new Pool(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Attention le fichier " + fileName + " n'existe pas !");
		}
	}
	
	public Board[] megaSolverPuzzle() {
		int nbCaseMemoireSolutions=100;
		int cotePlateau = this.pool.getSizeBoard();
		Board[] tabSolutions = new Board[nbCaseMemoireSolutions];
		for (int fill = 0 ; fill<nbCaseMemoireSolutions ; fill++) {
			tabSolutions[fill]=new Board(cotePlateau);
		}
		
		int k=0;
		Board plateauEssai = new Board(cotePlateau);
		solverPuzzle(plateauEssai, tabSolutions,0,0);
		
		return tabSolutions;
	}	
	
	
	//fonction recursive de résoloution
	public void solverPuzzle(Board plateauEssai, Board[] plateauSolution, int i, int j) {
		
		int cotePlateau = this.pool.getSizeBoard();
		int nbPieces = this.pool.pieceTab.length;
		
		// cas de la dernière case => finir plateau et passer au suivant
		if (i==cotePlateau-1 && j==cotePlateau-1) {
			for (int h = 0 ; h<nbPieces ; h++) {
				//cherche la dernière pièce libre
				if(!this.pool.utiliseTab[h] ) {
					Piece piece = this.pool.pieceTab[h];
					for (int tour = 0 ; tour<4 ; tour++) {
						if (plateauEssai.possible(piece,i,j)) {
							
							plateauEssai.setPiece(i, j, h, piece, this.pool);
							
							plateauSolution[nbSolutions]=plateauEssai;
							
							System.out.println("solution numéro " + (nbSolutions+1));
							plateauEssai.afficheBoard();
							nbSolutions++; //passage au plateau suivant	
							this.pool.pieceDisponible(h);
						}
						piece.rotation();
					} 					
				}
			}
		}
		
		//cas bout de ligne => passer en début de ligne suivante
		if (i!=cotePlateau-1 && j==cotePlateau-1) {
			
			for (int h = 0 ; h<nbPieces ; h++) {
				if(!this.pool.utiliseTab[h]) {
					Piece piece = this.pool.pieceTab[h];
					for (int tour = 0 ; tour<4 ; tour++) {
					if (plateauEssai.possible(piece,i,j)) {
						
						plateauEssai.setPiece(i, j, h, piece, this.pool);
						
						
						i++;
						j=0;
						
						solverPuzzle(plateauEssai,plateauSolution,i,j);
						i--;
						j=cotePlateau-1;
						this.pool.pieceDisponible(h);
						
						}
					piece.rotation();
					}
				}
			}
		}
		
		//cas général
		if (j!=cotePlateau-1 ) {
			
			for (int h = 0 ; h<nbPieces ; h++) {
				
				if(!this.pool.utiliseTab[h]) {
					
					Piece piece = this.pool.pieceTab[h];
					for (int tour = 0 ; tour<4 ; tour++) {
					if (plateauEssai.possible(piece,i,j)) {
						
						plateauEssai.setPiece(i, j, h, piece, this.pool);
						
						j++;
						solverPuzzle(plateauEssai,plateauSolution,i,j);
						this.pool.pieceDisponible(h);
						j--;
						
						}
					piece.rotation();
					}
				}
			}
		}
	}
	
	
		
		
		
	
		


	public boolean instParf(){
		
	   return (this.pool.toutParfait());
		
	}

}
