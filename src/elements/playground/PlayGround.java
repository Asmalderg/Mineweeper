package elements.playground;

import elements.cells.Cell;


public interface PlayGround {
    int getWidth();

    int getHeight();

    Cell getCell(int xPos, int yPos);

    Cell[] getCellsAround(int xPos, int yPos);

    int getDugCells();

    void setDugCells(int amount);
}
