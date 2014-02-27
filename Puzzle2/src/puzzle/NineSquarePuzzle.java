package puzzle;
import java.io.FileNotFoundException;

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



	public boolean instParf(){
		
	   return (this.pool.toutParfait());
		
	}

}
