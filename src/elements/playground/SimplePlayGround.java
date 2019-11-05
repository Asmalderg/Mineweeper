package elements.playground;

import elements.cells.Cell;

import java.util.ArrayList;
import java.util.List;

public class SimplePlayGround implements PlayGround {
    private final int width;
    private final int height;
    private final Cell[][] playField;
    private int dugCells;

    public SimplePlayGround(int width, int height, Cell[][] playField) {
        this.width = width;
        this.height = height;
        this.playField = playField;
        this.dugCells = 0;
    }

    @Override
    public int getDugCells() {
        return dugCells;
    }

    @Override
    public void setDugCells(int amount) {
        dugCells = amount;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Cell getCell(int xPos, int yPos) {
        return playField[yPos][xPos];
    }

    @Override
    public Cell[] getCellsAround(int xPos, int yPos) {
        List<Cell> cellsAround = new ArrayList<>(8);
        //Top-left
        if (xPos - 1 > -1 && yPos - 1 > -1) {
            cellsAround.add(getCell(xPos - 1, yPos - 1));
        }
        //Left
        if (xPos - 1 > -1) {
            cellsAround.add(getCell(xPos - 1, yPos));
        }
        //Left-Bottom
        if (xPos - 1 > -1 && yPos + 1 < getHeight()) {
            cellsAround.add(getCell(xPos - 1, yPos + 1));
        }
        //Bottom
        if (yPos + 1 < getHeight()) {
            cellsAround.add(getCell(xPos, yPos + 1));
        }
        //Bottom-right
        if (yPos + 1 < getHeight() && xPos + 1 < getWidth()) {
            cellsAround.add(getCell(xPos + 1, yPos + 1));
        }
        //right
        if (xPos + 1 < getWidth()) {
            cellsAround.add(getCell(xPos + 1, yPos));
        }
        //Right-top
        if (xPos + 1 < getWidth() && yPos - 1 > -1) {
            cellsAround.add(getCell(xPos + 1, yPos - 1));
        }
        //Top
        if (yPos - 1 > -1) {
            cellsAround.add(getCell(xPos, yPos - 1));
        }
        int cellsAmount = cellsAround.size();
        return cellsAround.toArray(new Cell[cellsAmount]);
    }

}
