import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by Tyler Cox on 11/16/2016.
 */
public class Card extends Button {
    public Color originalColor = getBackground();
    private final GameBoard gameBoard;
    private Color storedColor;

    public Card(GameBoard gameBoard,String label, Color backColor){
        super(label);
        this.gameBoard = gameBoard;
        storedColor = backColor;
        //Changes the color of the button when it is clicked.
        addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(getBackground().equals(backColor)){
                            setBackground(originalColor);
                        }
                        else {
                            setBackground(backColor);
                        }
                        Card card = (Card)e.getSource();
                        card.gameBoard.CardClicked(card);
                    }
                }

        );
    }

    public Color getColor(){
        return storedColor;
    }

    public void FlipBack(){
        setBackground(originalColor);
    }
}
