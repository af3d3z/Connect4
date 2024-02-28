package connect4;

import java.util.Arrays;

/**
 * Clase con todos los métodos y atributos del juego Connect4
 * @author th3-m0th
 * */
public class Connect4 {
	public Connect4 () {
		prepareBoard();
	}
	
	/**
	 * Constante que almacena el tamanio del tablero
	 * */
	final static int BOARD_SIZE = 4;
	
	/**
	 * Almacenará el tablero
	 * */
	static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
	
	/**
	 * Se encarga de rellenar el tablero con fichas.
	 * @param column Columna en la que se añadirá la ficha
	 * */
	void addChecker(int column, int player) {
		int position = board[0].length-1;
		int counter = 0;
		column--;//fix?
		// comprueba donde está la casilla libre (en caso de que haya)
		for(int i = 0; i < board[0].length; i++) {
			if(board[i][column] != ' ') {
				position--;
			}
		}
		
		if (position == -1) {
			System.out.println("(Couldn't insert checker) The checker fell to the ground.");
		}else if(player == 0) {
			board[position][column] = 'O';
		}else {
			board[position][column] = 'X';
		}
	}
	
	/**
	 * Imprime el tablero por pantalla
	 * */
	public static void printBoard() {		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print("|" + board[i][j] + "|");
			}
			System.out.println();
		}
		
		for(int i = 1; i <= board[0].length; i++) {
			System.out.print(" " + i + " ");
		}
		System.out.println();
	}
	
	
	/**
	 * Rellena el tablero de espacios
	 * */
	private static void prepareBoard() {
		for(char[] row : board) {
			Arrays.fill(row, ' ');
		}
	}
	/**
	 * Comprueba si ha ganado alguno de los dos jugadores
	 * */
	public static boolean checkWin(int player) {
		char figure = player == 0 ? 'O' : 'X';
		boolean res = false;
		int spaceCounter = 0;
		int counter = 0;
		
		try {
			for(int row = 0; row < board.length; row++) {
				for(int column = 0; column < board[0].length; column++) {
					if(board[row][column] == figure) {
						if(
								// horizontal
								(board[row][column+1] == figure && board[row][column+2] == figure && board[row][column+3] == figure)||
								// vertical
								(board[row+1][column] == figure && board[row+2][column] == figure && board[row+3][column] == figure)||
								// diagonal (right)
								(board[row-1][column+1] == figure && board[row-2][column+2] == figure && board[row-3][column+3] == figure)
						) {
							System.out.println(figure + " WINS");
							res = true;
						}
					}else if(board[row][column] == ' ') {
						spaceCounter++;
					}
					counter++;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {}		
		
		if(spaceCounter == 0 && counter > 4) {
			System.out.println("Board is full. " + figure + " wins.");
			res = true;
		}
		
		return res;
	}
}
