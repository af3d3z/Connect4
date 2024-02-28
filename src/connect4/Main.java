package connect4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// cuenta cada movimiento de la partida
		int movesCounter = 0;
		Connect4 c4 = new Connect4();
		
		System.out.println("Connect4");
		do {
			movesCounter++;
			int column = 0;
			System.out.println("Your turn: " + (movesCounter % 2 == 0 ? 'O' : 'X'));
			Connect4.printBoard();
			do {
				try {
					System.out.println("Insert the row: 1-" + Connect4.BOARD_SIZE);
					column = sc.nextInt();
				}catch(InputMismatchException e) {
					System.err.println("Row non-existent.");
					sc.nextLine();
				}
			}while(column > Connect4.BOARD_SIZE || column <= 0);		
			c4.addChecker(column, movesCounter % 2 == 0 ? 0 : 1);
			Connect4.printBoard();
		}while(!Connect4.checkWin(movesCounter % 2 == 0 ? 0 : 1));
	}
}
