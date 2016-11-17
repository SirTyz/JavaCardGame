import com.sun.corba.se.spi.activation.ActivatorOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        MenuBar mainMenu = new MenuBar();
        Menu gameOptions = new Menu("Options");
        MenuItem newGameMenu = new MenuItem("New Game");
        MenuItem gameInfo = new MenuItem("About");
        MenuItem exitGameMenu = new MenuItem("Exit");

        Restart restart = new Restart();
        newGameMenu.addActionListener(restart);

        Quit quit = new Quit();
        exitGameMenu.addActionListener(quit);

        About about = new About();
        gameInfo.addActionListener(about);

        gameOptions.add(newGameMenu);
        gameOptions.add(gameInfo);
        gameOptions.add(exitGameMenu);
        mainMenu.add(gameOptions);
        setMenuBar(mainMenu);
        setVisible(true);
    }


    public static void main(String[] args) {

        CardGame memory = new CardGame();
    }

    class Restart implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gameBoard.StartOver();
        }
    }

    class Quit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class About implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Find each card's match to win!\nCreated by: Tyler Cox");
        }
    }
}
