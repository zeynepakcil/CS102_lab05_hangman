import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelsHangmanView extends JPanel implements IHangmanView{
    private Hangman hangman;
    private JLabel numOfIncorrectTries;
    private JLabel knownSoFar;
    private JLabel usedLetters;
    private JLabel hasLost;

    public LabelsHangmanView(Hangman hangman){
        Font font = new Font("Arial", Font.BOLD, 30);

        this.hangman = hangman;

        numOfIncorrectTries = new JLabel(); numOfIncorrectTries.setFont(font);
        knownSoFar          = new JLabel(); knownSoFar.setFont(font);
        usedLetters         = new JLabel(); usedLetters.setFont(font);
        hasLost             = new JLabel(); hasLost.setFont(font);

        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new GridLayout(4,1));
          
        this.setBackground(Color.GREEN);
        
        this.add(numOfIncorrectTries);
        this.add(knownSoFar);
        this.add(usedLetters);
        this.add(hasLost);      
        
    }
    @Override
    public void updateView(Hangman hangmanModel) {
        numOfIncorrectTries.setText(hangmanModel.getNumOfIncorrectTries() + "/" + hangmanModel.getMaxAllowedIncorrectTries());
        knownSoFar.setText("Word: " + hangman.getKnownSoFar());
        usedLetters.setText("Used: " + hangman.getUsedLetters());
        if(hangman.isGameOver() && hangman.hasLost() && hangmanModel.getNumOfIncorrectTries() != 0) hasLost.setText("You lost");
        else if(hangman.isGameOver() && !hangman.hasLost() && hangmanModel.getNumOfIncorrectTries() != 0) hasLost.setText("You won");
    }
    
}
