// GUI tic-tac-toe game using 'swing' and 'awt' packages in java

// import necessary packages for create tic-tac-toe game
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// class for tic-tac-toe game design and logic
public class Game implements ActionListener {
    private JFrame frame;
    private JLabel Label;
    private JPanel labelPanel;
    private JLabel turnLabel;
    private JPanel trunlabelPanel;
    private JPanel gamePanel;
    private JPanel countPanel; 
    private JButton[] buttons = new JButton[9];
    private boolean xTurn = true;
    private int xWins = 0;
    private int oWins = 0;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel xLabel;
    private JLabel oLabel;
    private JLabel xWinsLabel;
    private JLabel oWinsLabel;
    private Player playerX;
    private Player playerO;

    // main logical code that contains design of tic-tac-toe and logic of tic-tac-toe
    public Game() {

        // create object of game-frame that contain game related different labels, buttons, message boxes etc.
        frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create object of tic-tac-toe label panel that contain main label
        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1, 1));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 00, 25));

        Label = new JLabel("TIC-TAC-TOE");
        Font LabelFont = new Font("Arial Rounded MT Bold", Font.PLAIN, 50);
        Label.setFont(LabelFont);
        Label.setHorizontalAlignment(SwingConstants.CENTER);

        // add label in label panel
        labelPanel.add(Label);

        // create object of tic-tac-toe player turnlabel panel that contain name of player
        trunlabelPanel = new JPanel();
        trunlabelPanel.setLayout(new GridLayout(1, 1));
        trunlabelPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        
        turnLabel = new JLabel();
        Font turnLabelFont = new Font("Comic Sans MS", Font.PLAIN, 35);
        turnLabel.setFont(turnLabelFont);
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // add label in trunlabel panel
        trunlabelPanel.add(turnLabel);

        // create object of tic-tac-toe game panel that contain different nine buttons
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(00, 25, 25, 25));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Bradley Hand ITC", Font.PLAIN, 100)); 
            buttons[i].setBackground(Color.LIGHT_GRAY); 
            buttons[i].setPreferredSize(new Dimension(200, 200));
            buttons[i].addActionListener(this);

            // add buttons in game panel
            gamePanel.add(buttons[i]);
        }

        // create object of tic-tac-toe control panel that count winning game of players
        countPanel = new JPanel();
        countPanel.setLayout(new GridLayout(2, 2));
        countPanel.setBorder(BorderFactory.createEmptyBorder(00, 50, 25, 50));

        xLabel = new JLabel("X Wins");
        Font xLabelFont = new Font("Comic Sans MS", Font.PLAIN, 25);
        xLabel.setFont(xLabelFont);
        xLabel.setHorizontalAlignment(SwingConstants.CENTER);

        oLabel = new JLabel("O Wins");
        Font oLabelFont = new Font("Comic Sans MS", Font.PLAIN, 25);
        oLabel.setFont(oLabelFont);
        oLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        xWinsLabel = new JLabel("" + xWins);
        Font xWinsLabelFont = new Font("Comic Sans MS", Font.PLAIN, 40);
        xWinsLabel.setFont(xWinsLabelFont);
        xWinsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        oWinsLabel = new JLabel("" + oWins);
        Font oWinsLabelFont = new Font("Comic Sans MS", Font.PLAIN, 40);
        oWinsLabel.setFont(oWinsLabelFont);
        oWinsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add lables in control panel
        countPanel.add(xLabel);
        countPanel.add(oLabel);
        countPanel.add(xWinsLabel);
        countPanel.add(oWinsLabel);

        // create object of Jpanel to add two objects in one position
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(labelPanel);
        northPanel.add(trunlabelPanel);

        // add panels in frame
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(countPanel, BorderLayout.SOUTH);
        frame.setSize(500, 750);
        frame.setVisible(true);

        // create inputbox to fetch player 'X' name from user with necessary validation
        String playerNameX;
        do {
            playerNameX = JOptionPane.showInputDialog(frame, "Enter Player X's name : ");

            if (playerNameX == null || playerNameX.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Player 'X' name is required.\nPlease enter a valid name.");
            } else if (!isAlphabetic(playerNameX.trim())) {
                JOptionPane.showMessageDialog(frame, "Invalid Player Name.\nPlayer 'X' name should contain only alphabets.");
            }
        } while (playerNameX == null || playerNameX.trim().isEmpty() || !isAlphabetic(playerNameX.trim()));

        String playerSymbolX = "X";

        // create inputbox to fetch player 'O' name from user with necessary validation
        String playerNameO;
        do {
            playerNameO = JOptionPane.showInputDialog(frame, "Enter Player O's name : ");

            if (playerNameO == null || playerNameO.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Player 'O' name is required.\nPlease enter a valid name.");
            } else if (!isAlphabetic(playerNameO.trim())) {
                JOptionPane.showMessageDialog(frame, "Invalid Player Name.\nPlayer 'O' name should contain only alphabets.");
            }
        } while (playerNameO == null || playerNameO.trim().isEmpty() || !isAlphabetic(playerNameO.trim()));

        String playerSymbolO = "O";

        playerX = new Player(playerNameX, playerSymbolX);
        playerO = new Player(playerNameO, playerSymbolO);

        // set text of labels after fetching players name
        turnLabel.setText(playerX.getName().toUpperCase() + "'s Turn");
        xLabel.setText(playerX.getName().toUpperCase() + " Wins");
        oLabel.setText(playerO.getName().toUpperCase() + " Wins");
    }

    // to fetch valid name that contains only alphabets
    private static boolean isAlphabetic(String input) {
        return input.matches("^[a-zA-Z]+$");
    }

    // method that change button and label text after check winner
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (xTurn) {
            button.setText(playerX.getSymbol());
            turnLabel.setText(playerO.getName().toUpperCase() + "'s Turn");
            button.setForeground(Color.RED);
        } else {
            button.setText(playerO.getSymbol());
            turnLabel.setText(playerX.getName().toUpperCase() + "'s Turn");
            button.setForeground(Color.BLUE);
        }
        button.setEnabled(false);
        xTurn = !xTurn;
        checkForWinner();
    }

    public void checkForWinner() { 

        // check for a win in the first row
        if (buttons[0].getText().equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[2].getText()) && !buttons[0].getText().isEmpty()) {
            if (buttons[0].getText().equals("X")) {
                JOptionPane.showMessageDialog(frame, playerX.getName().toUpperCase() + " IS WIN..!");
                xWins++;
            } else {
                JOptionPane.showMessageDialog(frame, playerO.getName().toUpperCase() + " IS WIN..!");
                oWins++;
            }
            updateWinsLabels(); 
            resetGame();
        }

        // check for a win in the second row
        if (buttons[3].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[5].getText()) && !buttons[3].getText().isEmpty()) {
            if (buttons[3].getText().equals("X")) {
                JOptionPane.showMessageDialog(frame, playerX.getName().toUpperCase() + " IS WIN..!");
                xWins++;
            } else {
                JOptionPane.showMessageDialog(frame, playerO.getName().toUpperCase() + " IS WIN..!");
                oWins++;
            }
            updateWinsLabels(); 
            resetGame();
        }

        // check for a win in the third row
        if (buttons[6].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[8].getText()) && !buttons[6].getText().isEmpty()) {
            if (buttons[6].getText().equals("X")) {
                JOptionPane.showMessageDialog(frame, playerX.getName().toUpperCase() + " IS WIN..!");
                xWins++;
            } else {
                JOptionPane.showMessageDialog(frame, playerO.getName().toUpperCase() + " IS WIN..!");
                oWins++;
            }
            updateWinsLabels(); 
            resetGame();
        }

        // check for a win in the first column
        if (buttons[0].getText().equals(buttons[3].getText()) && buttons[3].getText().equals(buttons[6].getText()) && !buttons[0].getText().isEmpty()) {
            if (buttons[0].getText().equals("X")) {
                JOptionPane.showMessageDialog(frame, playerX.getName().toUpperCase() + " IS WIN..!");
                xWins++;
            } else {
                JOptionPane.showMessageDialog(frame, playerO.getName().toUpperCase() + " IS WIN..!");
                oWins++;
            }
            updateWinsLabels(); 
            resetGame();
        }

        // check for a win in the second column
        if (buttons[1].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[7].getText()) && !buttons[1].getText().isEmpty()) {
            if (buttons[1].getText().equals("X")) {
                JOptionPane.showMessageDialog(frame, playerX.getName().toUpperCase() + " IS WIN..!");
                xWins++;
            } else {
                JOptionPane.showMessageDialog(frame, playerO.getName().toUpperCase() + " IS WIN..!");
                oWins++;
            }
            updateWinsLabels(); 
            resetGame();
        }

        // check for a win in the third column
        if (buttons[2].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[8].getText()) && !buttons[2].getText().isEmpty()) {
            if (buttons[2].getText().equals("X")) {
                JOptionPane.showMessageDialog(frame, playerX.getName().toUpperCase() + " IS WIN..!");
                xWins++;
            } else {
                JOptionPane.showMessageDialog(frame, playerO.getName().toUpperCase() + " IS WIN..!");
                oWins++;
            }
            updateWinsLabels(); 
            resetGame();
        }

        // check for a win in the main diagonal
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText()) && !buttons[0].getText().isEmpty()) {
            if (buttons[0].getText().equals("X")) {
                JOptionPane.showMessageDialog(frame, playerX.getName().toUpperCase() + " IS WIN..!");
                xWins++;
            } else {
                JOptionPane.showMessageDialog(frame, playerO.getName().toUpperCase() + " IS WIN..!");
                oWins++;
            }
            updateWinsLabels(); 
            resetGame();
            return;
        }

        // check for a win in the other diagonal
        if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled()) {
            if (buttons[2].getText().equals("X")) {
                JOptionPane.showMessageDialog(frame, playerX.getName().toUpperCase() + " IS WIN..!");
                xWins++;
            } else {
                JOptionPane.showMessageDialog(frame, playerO.getName().toUpperCase() + " IS WIN..!");
                oWins++;
            }
            updateWinsLabels(); 
            resetGame();
            return;
        }

        // check game is tie or not
        boolean tie = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) {
            JOptionPane.showMessageDialog(frame, "IT'S A TIE GAME...!");
            resetGame();
        }
    }


    // method that change winners count
    private void updateWinsLabels() {
        xWinsLabel.setText("" + xWins);
        oWinsLabel.setText("" + oWins);
    }

    // method that reset game
    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            turnLabel.setText(playerX.getName().toUpperCase() + "'s Turn");
        }
        xTurn = true;
    }
}

// class for player name and symbol
class Player {
    private String name;
    private String symbol;
    public Player() {
        
    }
    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public String getSymbol() {
        return symbol;
    }
}
