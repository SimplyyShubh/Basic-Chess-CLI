// package mini_project ;

import java.util.*;

public class ChessMain {

	// main function for testing
	public static void main(String[] args) {

		System.out.println();
		System.out.println(" Hello! And welcome to Chess!"); // these two lines are always shown when game starts
		boolean mainMenu = true; // true --> game is still playing

		while (mainMenu) {

			try {
				System.out.println();
				System.out.println(" *****************************************");
				System.out.println("                 MAIN MENU             ");
				System.out.println(" *****************************************");
				System.out.println("            1. Play a new game.			");
				System.out.println(" *****************************************");
				System.out.println("         2. Display the help menu.		");
				System.out.println(" *****************************************");

				Scanner userInput = new Scanner(System.in);
				String inputString;

				System.out.print(">>Please type in option number: ");
				inputString = userInput.nextLine();
				if (inputString.charAt(0) == '1') { // start a new game!
					System.out.println();
					ChessBoard chessBoard = new ChessBoard();
					Move mover = new Move(chessBoard);
					HelpMenu help = new HelpMenu();

					Player white = new Player(0);
					System.out.println("Hello Player 1. Please input your desired user name: ");
					white.setName(userInput.nextLine());
					System.out.println();

					Player black = new Player(1);
					System.out.println("And hello Player 2. Please input your desired user name: ");
					black.setName(userInput.nextLine());

					System.out.println();
					System.out.println("Thank you both very much.");

					chessBoard.initBoard(); // initiate the board, start game

					boolean turn = true; // white starts the game
					String source, destin;

					play: while (true) {
						if (turn) { //Whites Turn
							chessBoard.setTurn(0);
							System.out.println("Type 'H' for help and to access specific commands.");
							System.out.println();
							System.out.println("Input current coordinates of the piece that you want to move.");

							if (mover.checkCheck(white.getColor())) {
								System.out
										.println(white.getName() + "(White), you are in check. Proceed with caution.");
							} else {
								System.out.println(white.getName() + "(White) it is your turn. Choose wisely.");
							}

							source = userInput.nextLine();
							if (source.charAt(0) == 'H') { // help menu!
								help.display();
								continue play; // if help just exited normally, restart player's turn
							}

							System.out.println("Input coordinates of the destination space.");
							destin = userInput.nextLine();

							if (destin.charAt(0) == 'H') { // help menu!
								help.display();
								continue play; // if help just exited normally, restart player's turn
							}

							try {
								if(!mover.move(source, destin, white)) // check if move is valid
									System.out.println("OOPS Illegal Move!!!! Try Again");
								 else 
									turn = false;
							} catch (NullPointerException e) {
								System.out.println("\nOOPS Illegal Move!!!! Try Again");
							}

						}
						else { // black player's turn!
							chessBoard.setTurn(1);
							System.out.println("Type 'H' for help and to access specific commands.");
							System.out.println();

							System.out.println("Input current coordinates of the piece that you want to move.");
							if (mover.checkCheck(black.getColor())) {
								System.out
										.println(black.getName() + "(Black), you are in check. Proceed with caution.");
							} else {
								System.out.println(black.getName() + "(Black) it is your turn. Choose wisely.");
							}
							source = userInput.nextLine();
							if (source.charAt(0) == 'H') { // help menu!
								help.display();
								continue play; // if help just exited normally, restart player's turn
							}
							System.out.println("Input coordinates of the destination space.");
							destin = userInput.nextLine();
							if (destin.charAt(0) == 'H') { // help menu!
								help.display();
								continue play; // if help just exited normally, restart player's turn
							}
							try {
								if (!mover.move(source, destin, black))
									System.out.println("OOPS Illegal Move!!!! Try Again");
								else
									turn = true;
							} catch (NullPointerException e) {
								System.out.println("\nOOPS Illegal Move!!!! Try Again");
							}
						}
					}
				} else if (inputString.charAt(0) == '2') { // display help!
					HelpMenu help = new HelpMenu();
					help.display();
				} else {
					System.out.println("I did not recognize that command. Please try again.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("OOPS Try again");
			}
		}
	}
}