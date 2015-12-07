/*
 * Michelle Chu (myc2dc) & Miranda Wang 
 */
import java.util.Random;

public class Board {
	
	//prints a nxn random board to the console screen
	public void consolePrint(int n){ 
		String alphabet = "AABCDEEFGHIIIJKLMNOOOPQRSSTUVWXYZ"; //more vowels = more valid words
	    int alphaLength = alphabet.length();

	    Random r = new Random();
	    for(int j = 0; j < n; j++) { 
		    for (int i = 0; i < n; i++) {
		    	System.out.print("|");
		        System.out.print(alphabet.charAt(r.nextInt(alphaLength)));
		    }
		    System.out.print("|");
		    System.out.println("");
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board b = new Board();
		b.consolePrint(10);
	}

}
