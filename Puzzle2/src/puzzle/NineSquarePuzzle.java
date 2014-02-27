package puzzle;
import java.io.FileNotFoundException;

import java.util.Arrays;

import puzzle.Pool;


public class NineSquarePuzzle {
	
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
		int nbSolutions=100;
		int cotePlateau = this.pool.getSizeBoard();
		Board[] tabSolutions = new Board[nbSolutions];
		for (int fill = 0 ; fill<nbSolutions ; fill++) {
			tabSolutions[fill]=new Board(cotePlateau);
		}
		
		int k=0;
		
		solverPuzzle(tabSolutions,0,0,k);
		
		return tabSolutions;
	}	
	
	
	//fonction recursive de résoloution
	public void solverPuzzle(Board[] plateau, int i, int j, int k) {
		
		int cotePlateau = this.pool.getSizeBoard();

		if (i==cotePlateau && j==cotePlateau) {
			for (int h = 0 ; h<cotePlateau ; h++) {
				if(!this.pool.utiliseTab[h]) {
					Piece piece = this.pool.pieceTab[h];
					for (int tour = 0 ; 0<4 ; tour++) {
					if (plateau[k].possible(piece,i,j)) {
						System.out.println("pose pièce");
						plateau[k].setPiece(i, j, h, piece, this.pool);
					Arrays.fill(this.pool.utiliseTab, false);
					k++;
					System.out.println("pièce placée en (" +i+ ";" +j+ ")");
					System.out.println("fin du plateau");
						}
					} 
				}
			}
		}
		
		if (i==cotePlateau && j!=cotePlateau) {
			for (int h = 0 ; h<cotePlateau ; h++) {
				if(!this.pool.utiliseTab[h]) {
					Piece piece = this.pool.pieceTab[h];
					for (int tour = 0 ; 0<4 ; tour++) {
					if (plateau[k].possible(piece,i,j)) {
						System.out.println("pose pièce");
						plateau[k].setPiece(i, j, h, piece, this.pool);
						System.out.println("pièce placée en (" +i+ ";" +j+ ")");
						j++;
						solverPuzzle(plateau,i,j,k);
						
						System.out.println("dernière ligne");
						}
					}
				}
			}
		}
		
		if (i!=cotePlateau && j==cotePlateau) {
			for (int h = 0 ; h<cotePlateau ; h++) {
				if(!this.pool.utiliseTab[h]) {
					Piece piece = this.pool.pieceTab[h];
					for (int tour = 0 ; 0<4 ; tour++) {
					if (plateau[k].possible(piece,i,j)) {
						System.out.println("pose pièce");
						plateau[k].setPiece(i, j, h, piece, this.pool);
						System.out.println("pièce placée en (" +i+ ";" +j+ ")");
						i++;
						j=0;
						solverPuzzle(plateau,i,j,k);
						System.out.println("saut de ligne");
						}
					}
				}
			}
		}
		
		if (i!=cotePlateau && j!=cotePlateau) {
			System.out.println("cherche pièce pour emplacement (" +i+ ";" +j+ ")");
			for (int h = 0 ; h<cotePlateau ; h++) {
				System.out.println("cherche pièce");
				if(!this.pool.utiliseTab[h]) {
					System.out.println("essaye pièce libre");
					Piece piece = this.pool.pieceTab[h];
					for (int tour = 0 ; 0<4 ; tour++) {
					if (plateau[k].possible(piece,i,j)) {
						System.out.println("pose pièce");
						plateau[k].setPiece(i, j, h, piece, this.pool);
						System.out.println("pièce placée en (" +i+ ";" +j+ ")");
						j++;
						solverPuzzle(plateau,i,j,k);
						}
					}
				}
			}
		}
	}
	
		
		
		
	
		


	public boolean instParf(){
		
	   return (this.pool.toutParfait());
		
	}

}
