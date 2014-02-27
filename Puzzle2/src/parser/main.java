package parser;

import java.io.FileNotFoundException;

import puzzle.NineSquarePuzzle;

public class main {

	public static void main(String[] args) {
	 Parser scan = new Parser();
	 try {
		scan.reader("data1.txt");
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	}
	
	NineSquarePuzzle nSP = new NineSquarePuzzle("data2.txt");
}
