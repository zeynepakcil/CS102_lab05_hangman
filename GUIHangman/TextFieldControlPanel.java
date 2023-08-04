import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldControlPanel extends JPanel{
    private Hangman hangman;
    private JTextField textField;

    public TextFieldControlPanel(Hangman hangman){
        this.hangman = hangman;
        textField = new JTextField(10);        
        this.add(textField);
        
        textField.addActionListener(e -> {
            String input = textField.getText();
            for(int i = 0; i < input.length(); i++)
                hangman.tryThis(input.charAt(i));
            textField.setText("");
        });
    }

   
}
