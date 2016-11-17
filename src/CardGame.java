import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Tyler Cox on 11/16/2016.
 */
public class CardGame extends JFrame {

    private GameBoard gameBoard = new GameBoard();

    public CardGame() {
        setSize(200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(gameBoard);
        setVisible(true);
    }


    public static void main(String[] args) {
        CardGame memory = new CardGame();
    }
}
