package gui;

import elements.cells.Cell;
import game.MinerGame;
import gameHandlers.gameEvents.GameEventInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class CellButtonListener implements ActionListener  {
    private MinerGame game;
    private int playgroundWidth;
    private int playgroundHeight;
    private CellButton[][] cellButtons;
    private GameEventInterface handler;

    public CellButtonListener() {}

    public void setGame(MinerGame game) {
        handler = game.getHandler();
        this.game = game;
        playgroundHeight = game.getPlayGround().getHeight();
        playgroundWidth = game.getPlayGround().getWidth();
    }

    public void setCellButtons(CellButton[][] cellButtons) {
        this.cellButtons = cellButtons;
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        if (e.getSource() instanceof  CellButton) {
            CellButton button = (CellButton) e.getSource();
            int xPos = button.getXPos();
            int yPos = button.getYPos();
            game.digCell(xPos, yPos);
            try {
                for (int i = 0; i < playgroundHeight; i++) {
                    for (int j = 0; j < playgroundWidth; j++) {
                        Cell cell = game.getPlayGround().getCell(j, i);
                        if (cell.isDug()) {
                            cellButtons[i][j].setEnabled(false);
                            try {
                                CellsIconSetter.getInstance().setCellsView(cellButtons[i][j], game.getPlayGround());
                            }catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
                if (handler.isGameEnded()) {
                    EndGamePanel endGamePanel = new EndGamePanel(new JFrame());
                    if (handler.isWin()) {
                        endGamePanel.showWinMessage();
                    } else {
                        endGamePanel.showLoseMessage();
                    }
                    /////Block cell
                    for (int i = 0; i < playgroundHeight; i++) {
                        for (int j = 0; j < playgroundWidth; j++) {
                            cellButtons[i][j].setEnabled(false);
                            try {
                                CellsIconSetter.getInstance().setCellsView(cellButtons[i][j], game.getPlayGround());
                            }catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }catch (NullPointerException exception) {
                throw new NullPointerException("Objects CELLS[][] or game haven't been created yet");
            }

        }
    }
}
