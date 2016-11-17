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
    private Card card1 = null;
    private Card card2 = null;
    private Random rand = new Random();

    public GameBoard(){
        setLayout(new GridLayout(ROWS,COLUMNS));
        InitializeGameBoard();
    }

    public void CardClicked(Card card){
        if (card1 == null) {
            card1 = card;
        }
        else if(card2 == null) {
            card2 = card;
            if(card1.getColor() == card2.getColor()){
                remove(card1);
                remove(card2);
                card1 = null;
                card2 = null;
            }
            else{
                card1.flipBack();
                card2.flipBack();
                card1 = null;
                card2 = null;
            }
        }
    }

    private void InitializeGameBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);

                Color backColor = Color.getHSBColor(r, g, b);

                Card newCard1 = new Card(this, "", backColor);
                Card newCard2 = new Card(this, "", backColor);
                add(newCard1);
                cells[row][column] = newCard1;
                column++;
                add(newCard2);
                cells[row][column] = newCard2;

            }
        }

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

    }


    public void StartOver(){
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);

                Color backColor = Color.getHSBColor(r, g, b);

                Card newCard1 = new Card(this, "", backColor);
                Card newCard2 = new Card(this, "", backColor);

                cells[row][column].setBackground(newCard1.getColor());
                column++;
                cells[row][column].setBackground(newCard2.getColor());

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
