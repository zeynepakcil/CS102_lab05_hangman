import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import Hangman.Hangman;

public class GallowsHangmanView extends JPanel implements IHangmanView{
    
    Hangman hangman;
    Ellipse2D.Double head;
    Line2D.Double body, leftArm, rightArm, leftLeg, rightLeg;
    Shape[] shapes;

    public GallowsHangmanView(Hangman hangman){
        this.setBackground(Color.BLUE);

        shapes = new Shape[6];
        shapes[0] = new Ellipse2D.Double(100, 50, 100,50);              //head
        shapes[1] = new Line2D.Double(150, 100, 150,300);           //body     
        shapes[2] = new Line2D.Double(150, 100, 100,200);           //leftArm  
        shapes[3] = new Line2D.Double(150, 100,200, 200);           //rightArm 
        shapes[4] = new Line2D.Double(150,300, 100,400);            //leftLeg  
        shapes[5] = new Line2D.Double(150,300, 200,400);            //rightLeg 
    }

    @Override
    public void updateView(Hangman hangman) {
        this.hangman = hangman;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(10));
        //g2d.drawLine(FRAMEBITS, ERROR, ALLBITS, ABORT);        
        g.drawLine(300, 0, 300,500);
        for(int i = 0; i < hangman.getNumOfIncorrectTries(); i++){
            g2d.draw(shapes[i]);
        }
    }
    
}
