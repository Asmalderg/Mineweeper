package gui;

import game.SimpleMinerGame;
import elements.mode.BeginnerMode;
import elements.mode.GameMode;
import elements.mode.GameModeFactoryMethod;
import gameHandlers.gameEvents.GameEventHandler;
import gameHandlers.gameEvents.GameEventInterface;
import game.MinerGame;
import res.IconGetter;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;


public class GuiGame {


    private final JFrame mainFrame;
    private GameMode gameMode;
    private MenuBar menuBar;
    private GridLayout gameField;
    private CellButton[][] cellsArray;
    private CellButtonListener cellButtonListener;

    public GuiGame() throws IOException {

        mainFrame = new JFrame("MinerSweeper");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setIconImage(IconGetter.getIcon("mine"));

        cellButtonListener = new CellButtonListener();
        MenuButtonsListener menuButtonsListener = new MenuButtonsListener(this);
        menuBar = new MenuBar(menuButtonsListener);

        mainFrame.setJMenuBar(menuBar);
        gameMode = BeginnerMode.getInstance();
    }

    public void startGame() throws IOException {
        GameEventInterface gameEventHandler = new GameEventHandler();
        MinerGame game = new SimpleMinerGame(gameEventHandler);

        String selectedMenuMode = menuBar.getActiveGameMode();

        for (GameMode mode:GameModeFactoryMethod.getInstance().getAllModes()) {
            if (mode.getName().equals(selectedMenuMode)) {
                this.gameMode = mode;
            }
        }

        int columns = gameMode.getWidth();
        int rows = gameMode.getHeight();




        if (gameField != null) {
            gameField.removeLayoutComponent(mainFrame);
            int cellColumns = cellsArray[0].length;
            for (CellButton[] cellButtons : cellsArray) {
                for (int j = 0; j < cellColumns; j++) {
                    mainFrame.remove(cellButtons[j]);
                }
            }
        }


        gameField = new GridLayout(rows, columns, 0, 0);
        mainFrame.setLayout(gameField);

        cellsArray = new CellButton[rows][columns];
        cellButtonListener.setCellButtons(cellsArray);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                CellButton button = new CellButton(j, i);
                button.setPreferredSize(new Dimension(30, 30));
                cellsArray[i][j] = button;

                button.addActionListener(cellButtonListener);
                mainFrame.add(button);
            }
        }
        game.startNewGame(gameMode);
        cellButtonListener.setGame(game);


        mainFrame.pack();
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

    }
}
