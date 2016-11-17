import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Tyler Cox on 11/16/2016.
 */
public class GameBoard extends JPanel {
    private final int BOARDSIZE = 4;
    private final int ROWS = BOARDSIZE;
    private final int COLUMNS = BOARDSIZE;

    private Card[][] cells = new Card[ROWS][COLUMNS];
    private Card[][] shuffledCells = new Card[ROWS][COLUMNS];
    private Random rand = new Random();
    private Card oldCard;

    public GameBoard(){
        setLayout(new GridLayout(ROWS,COLUMNS));
        InitializeGameBoard();

    }

    private void InitializeGameBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);

                Color backColor = Color.getHSBColor(r, g, b);

                Card newCard = new Card(this, "", backColor);

                if (column % 2 == 0) {
                    cells[row][column] = newCard;
                    oldCard = newCard;
                    add(newCard);
                }
                else {
                    cells[row][column] = oldCard;
                    newCard = oldCard;
                }
                add(newCard);

            }
        }
/*
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLUMNS; c++) {
                int r1 = rand.nextInt(BOARDSIZE);
                int c1 = rand.nextInt(BOARDSIZE);

                while(shuffledCells[r1][c1] != null){
                    r1 = rand.nextInt(BOARDSIZE);
                    c1 = rand.nextInt(BOARDSIZE);
                }
                shuffledCells[r1][c1] = cells[r][c];
            }
        }
        */
    }
}
