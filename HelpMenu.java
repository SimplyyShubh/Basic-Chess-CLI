// package mini_project ;

import java.util.*;

public class HelpMenu {

	private ChessBoard board;

	// get board method
	public ChessBoard getBoard() {
		return board;
	}

	// app info
	public void appInfo() {
		for (int i = 0; i < 5; i++) {
			System.out.println();
		}
		System.out.println("Basic Chess App");
		System.out.println("Developed and built using Java");
	}

	// Basic Chess Rules
	public void basicChessInfo() {
		for (int i = 0; i < 5; i++) {
			System.out.println();
		}
		System.out.println("To learn about the fantastic game of chess..");
		System.out.println("Watch any Chess video on Youtube, as this place is just not enough to teach you CHESS");
	}

	// quit game
	public void quitGame() {
		for (int i = 0; i < 5; i++) {
			System.out.println();
		}
		System.out.println("\nGAME OVER!!!!!! \nExiting........");
		System.exit(1);
	}

	// display help menu, should allow user to navigate through help
	public void display() {
		for (int i = 0; i < 5; i++) {
			System.out.println();
		}
		Scanner scn = new Scanner(System.in);
		System.out.println("Help is here to HELP YOU!!");

		while (true) {
			System.out.println("The following are your options:");
			System.out.println("1. App Info");
			System.out.println("2. Basic Chess Rules");
			System.out.println("3. Return to Game");
			System.out.println("3. Quit Game");
			System.out.println();
			System.out.println("Please enter the number of your choice.");
			String choice = scn.nextLine();
			if (choice.charAt(0) == '1') {
				appInfo();
				break;
			} else if (choice.charAt(0) == '2') {
				basicChessInfo();
				break;
			} else if (choice.charAt(0) == '3') {
				break;
			} else if (choice.charAt(0) == '4') {
				quitGame();
				break;
			} else {
				System.out.println("That is not an option, try again.");
			}
		}
	}
}
