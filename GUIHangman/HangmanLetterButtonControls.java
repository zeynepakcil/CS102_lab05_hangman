import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView{

    public HangmanLetterButtonControls(String hangmanLetters, int row, int col){
        super(hangmanLetters, row, col);
        this.setPreferredSize(new Dimension(300,500));
        this.setFont( new Font( "Times New Roman", Font.BOLD, 30 ) );
    }

    @Override
    public void updateView(Hangman hangman) {
        setDisabled(hangman.getUsedLetters());
            if(hangman.isGameOver()) setEnabledAll(false);
    }
    
}