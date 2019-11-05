package elements.cells;

import elements.cells.cellState.CellState;
import elements.mines.Mine;

public interface Cell {
    CellState getCellState();

    void digCell();

    boolean isDug();

    boolean isMined();

    void setMine(Mine mine);

    int getMinesAround();

    void setMinesAround(int minesAmount);

    int getXPos();

    int getYPos();
}
