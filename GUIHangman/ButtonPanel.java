import java.awt.GridLayout;

import javax.swing.JPanel;

import Hangman.Hangman;

public class ButtonPanel extends JPanel implements IHangmanView{
    public ButtonPanel(NewGameButtonControl newGame, JokerButton jokerButton){
        this.setLayout(new GridLayout(1,2));
        this.add(newGame);
        this.add(jokerButton);
    }

    @Override
    public void updateView(Hangman hangmanModel) {}
}
