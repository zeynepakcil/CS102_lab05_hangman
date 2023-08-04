import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman{		
		
	HangmanModel		hangman;
	IHangmanSetup		basicSetup;
	ConsoleHangmanView	consoleView;

	TextFieldControlPanel tfControlPanel;
	NewGameButtonControl button;
	LabelsHangmanView labelsHangmanView;
	GallowsHangmanView gallowsHangmanView;
	HangmanLetterButtonControls hangmanLetterButtonControls;
	JokerButton jokerButton;
	public GUIHangman(){
    	System.out.println( "Start of GUIHangman\n");

		basicSetup = new BasicSetup();
		hangman = new HangmanModel(basicSetup);
		consoleView = new ConsoleHangmanView();

		hangman.addView(consoleView);

		tfControlPanel = new TextFieldControlPanel(hangman);
		button = new NewGameButtonControl(hangman);
		button.addActionListener(e -> {
			hangman.initNewGame();
			hangmanLetterButtonControls.setEnabledAll(true);
		});
		labelsHangmanView = new LabelsHangmanView(hangman);
		gallowsHangmanView = new GallowsHangmanView(hangman);
		hangmanLetterButtonControls = new HangmanLetterButtonControls(hangman.getAllLetters(), 13, 2);
		hangmanLetterButtonControls.setVisible(true);
		hangmanLetterButtonControls.addActionListener(e ->{
			JButton button = (JButton)e.getSource();
			String inputted = button.getText();
			char letter = inputted.charAt(0);	

			hangman.tryThis(letter);

		});

		jokerButton = new JokerButton(hangman, hangmanLetterButtonControls);

		jokerButton.addActionListener(e ->{
			jokerButton.useJoker();
		});

		IHangmanView buttonPanel = new ButtonPanel(button, jokerButton);
			
		hangman.addView(gallowsHangmanView);
		hangman.addView(button);
		hangman.addView(jokerButton);
		hangman.addView(hangmanLetterButtonControls);
		hangman.addView(labelsHangmanView);
		hangman.addView(jokerButton);

		new SimpleJFrame( "GUIHangman", 											// title
							gallowsHangmanView,						    				// center
							tfControlPanel,(JPanel) buttonPanel,						// north, south
							hangmanLetterButtonControls, labelsHangmanView );			// east, west

		// this is an infinite loop reading from the console... not clever!
		ConsoleControl.controlFor( hangman);
		
	}

	public static void main( String[] args)
	{
		new GUIHangman();

  		/* // This is the approved way to initialise GUIs
  		// but won't work with the ConsoleControl as is!
  		// --------------------------------------------
  		SwingUtilities.invokeLater(
  			new Runnable() {
  			    public void run() {
  	        		new GUIHangman();
  	        		new GUIHangman();
  	    		}
  			}); */
	}

} // end of class GUIHangman
