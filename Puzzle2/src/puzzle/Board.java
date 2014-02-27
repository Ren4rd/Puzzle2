package puzzle;

public class Board {
	public Piece[][] plateauTab;
	
	public Board(int sideLength) {
		this.plateauTab = new Piece[sideLength][sideLength];
	}
	
	public Board(Piece[][] plateauTab) {
		this.plateauTab = plateauTab;
	}
	
	public void setPiece(int i, int j, int n, Piece piece, Pool piscine) {
		this.plateauTab[i][j]=piece;	
		piscine.utiliseTab[n]=true;
	}
	
	
	
	public boolean possible(Piece piece,int i, int j){
		
		if (i!=0){
		if (piece.getValTab()[0]+plateauTab[i-1][j].getValTab()[2]!=0){
			return(false);	
			}
		}
		
		if (j!=0){
		if (piece.getValTab()[3]+plateauTab[i][j-1].getValTab()[1]!=0){
			return(false);	
			}
		}
		return true;
		
	}
	
	public void afficheBoard(){
	
		for (int i=0;i<plateauTab.length; i++ ){
	      System.out.print("+--------------");
		}
		System.out.println("+");
		
		
		for (int i=0;i<plateauTab.length; i++ ){
			
		    for (int j=0;j<plateauTab.length; j++){
			System.out.print("|    "+plateauTab[i][j].getValTab()[0]+"    ");
			}
			System.out.print("|");
			
			for (int j=0;j<plateauTab.length; j++){
			System.out.println("|  "+this.plateauTab[i][j].getValTab()[3]+" ["+this.plateauTab[i][j].getEtiquette()+this.plateauTab[i][j].getIndiceRota()+"] "+this.plateauTab[i][j].getValTab()[1]+"  ");
		    }
			System.out.print("|");
			
			for (int j=0;j<plateauTab.length; j++){
				System.out.print("|    "+plateauTab[i][j].getValTab()[2]+"    ");
			}
			System.out.print("|");
			
		}	
		
			
		for (int i=0;i<plateauTab.length; i++ ){
		  System.out.print("+--------------");
		}
		System.out.print("+");
	}
	
}
	


	


