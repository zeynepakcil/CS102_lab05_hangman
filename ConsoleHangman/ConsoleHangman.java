import java.util.Scanner;

import Hangman.IHangmanSetup;

/**
 * ConsoleHangman
 *
 * @author
 * @version 1.00 2013/4/7
 */

public class ConsoleHangman{
    public static void main( String[] args)
	{	int occurrence;
		char guess;
    	Scanner scanner = new Scanner( System.in);
		// VARIABLES
		HangmanModel hangmanModel;
		ConsoleHangmanView view;
		ConsoleHangmanView otherView;
		IHangmanSetup setup = new BasicSetup();
		// PROGRAM CODE
		hangmanModel = new HangmanModel(setup);
		view = new ConsoleHangmanView();
		otherView = new ConsoleHangmanView();
		hangmanModel.addView(view);
		hangmanModel.addView(otherView);
		System.out.println( "------------------------ Game Starts ------------------------" );

		// ToDo - allow user to repeatedly enter a letter and tryThis letter
		//		  then show game status, until gameover. Finally report win/lose.
		int round = 1;
		do{
			System.out.println("------------------ Round " + round + " ------------------");
			if(round > 1) System.out.println("Letters you tried: " + hangmanModel.getUsedLetters());
			System.out.print("Make a guess: ");
			guess = scanner.next().charAt(0);
			occurrence = hangmanModel.tryThis(guess);
			if(occurrence == 0) System.out.println("oops, not found:(");
			else System.out.println("yep, you found it!");
			round++;
		}
		while(!hangmanModel.isGameOver());
	}

	
} 