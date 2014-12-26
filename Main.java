import java.io.*;
import java.util.Vector;
import java.lang.StringBuilder;

public class Main {

	public static int playerPosCol, playerPosRow;
	public static Vector<String> board = new Vector<String>();
	static char space = ' ';
    static char used = 'o';
    static char goal = '.';
    static char player = '@';
    static char plus = '+';
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String line = "";
		while(true) {
			
			line = br.readLine();
			if(line.equals("end"))
				break;
			
			board.add(line);
			
		} // End while
		
		System.out.println("lol");


		findPlayer();
		
		findPath(playerPosRow, playerPosCol, "");
		
		System.out.println("no path");
		
	} // main
	
	private static void findPath(int i, int j, String direction) {
		if(board.get(i).charAt(j) == goal) {
			System.out.println(direction.substring(1));
			System.exit(0);
		} 
		
		if(board.get(i).charAt(j) == space) {
			
			StringBuilder tmp = new StringBuilder(board.get(i));
			tmp.setCharAt(j, used);					
			board.add(i, tmp.toString());
			board.remove(i + 1);
			
			findPath(i+1, j,direction + " D");
			findPath(i, j+1,direction + " R");
			findPath(i-1, j,direction + " U");
			findPath(i, j-1,direction + " L");
					
		}
	}
	
	private static void findPlayer() {
		for(int i = 0; i < board.size(); i++) {
			for(int j = 0; j < board.get(i).length(); j++) {
				if(board.get(i).charAt(j) == player) {
					StringBuilder tmp = new StringBuilder(board.get(i));
					tmp.setCharAt(j, space);
					playerPosCol = j; playerPosRow = i;
					board.add(playerPosRow, tmp.toString());
					board.remove(playerPosRow + 1);		
					break;
				}
				
				if(board.get(i).charAt(j) == plus) {
					System.out.println("");
					System.exit(0);
				}
			}
		}
	}
} // End Main
