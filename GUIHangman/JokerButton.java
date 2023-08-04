import javax.swing.JButton;

public class JokerButton extends JButton implements IHangmanView{
    private Hangman hangman;
    private LetterButtonControls letterButtonControls;
    public JokerButton(HangmanModel hangman, LetterButtonControls letterButtonControls){
        super("Joker");
        this.hangman = hangman;
        this.setEnabled(true);
        this.letterButtonControls = letterButtonControls;
    }
    @Override
    public void updateView(Hangman hangmanModel) {}
    
    public void enableJoker(){
        this.setEnabled(true);
    }



    public void useJoker(){
        char letter;
        String letters = "";
        for(int i = 0; i < 13 - hangman.getUsedLetters().length(); i++){
            int r = (int) (Math.random() * 25) ;
            letter = hangman.getAllLetters().charAt(r);
            while(hangman.secretWord.toString().contains(""+letter) || hangman.getUsedLetters().contains(""+letter)){
                r = (int)(Math.random() * 25 );
                letter = hangman.getAllLetters().charAt(r);
            }
            letters += "" + letter;
        }        
        letterButtonControls.setDisabled(letters);
        this.setEnabled(false);
    }
}
