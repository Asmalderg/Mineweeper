package elements.cells;

import elements.cells.cellState.CellState;
import elements.mines.Mine;
import elements.mines.MineStatus;

public class SimpleCell implements Cell {
    private final int xPos;
    private final int yPos;
    private Mine mine;
    private int minesAround;
    private CellState state;
    private boolean isDug;

    public SimpleCell(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        mine = null;
        isDug = false;
        minesAround = 0;
        state = CellState.EMPTY;
    }

    @Override
    public boolean isDug() {
        return isDug;
    }

    @Override
    public void digCell() {
        isDug = true;
        if (isMined()) {
            mine.touchMine();
            if (mine.getStatus() == MineStatus.DETONATED) {
                this.state = CellState.DESTROYED;
            }
        }
    }

    @Override
    public boolean isMined() {
        return mine != null;
    }

    @Override
    public void setMine(Mine mine) {
        this.state = CellState.MINED;
        this.mine = mine;
    }

    @Override
    public int getMinesAround() {
        return minesAround;
    }

    @Override
    public void setMinesAround(int minesAmount) {
        this.state = CellState.MINES_NEAR;
        this.minesAround = minesAmount;
    }

    @Override
    public CellState getCellState() {
        return state;
    }

    @Override
    public int getXPos() {
        return xPos;
    }

    @Override
    public int getYPos() {
        return yPos;
    }
}
