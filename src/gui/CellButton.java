package gui;

import javax.swing.*;

class CellButton extends JButton {
    private final int xPos;
    private final int yPos;

    public CellButton(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}
