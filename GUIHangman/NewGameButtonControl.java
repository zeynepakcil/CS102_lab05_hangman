import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Hangman.Hangman;

public class NewGameButtonControl extends JButton implements IHangmanView{
    private Hangman hangman;

    public NewGameButtonControl(HangmanModel hangman){
        super("New Game");
        this.hangman = hangman;
        this.setEnabled(false);
        this.addActionListener(e ->{
                hangman.initNewGame();
                this.setEnabled(false);
            });
                
    }

    @Override
    public void updateView(Hangman hangmanModel) {
        if(hangman.isGameOver())
            setEnabled(true);
    }
}
