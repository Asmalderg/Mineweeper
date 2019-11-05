package gui;

import elements.cells.Cell;
import elements.cells.cellState.CellState;
import elements.playground.PlayGround;
import res.IconGetter;
import view.CellViewer;

import javax.swing.*;
import java.io.IOException;

public class CellsIconSetter {

    private static final CellsIconSetter instance = new CellsIconSetter();

    private CellsIconSetter() {}

    public static CellsIconSetter getInstance() {
        return instance;
    }

    public void setCellsView(CellButton button, PlayGround playGround) throws IOException {
        CellViewer viewer = CellViewer.getInstance();

        Cell cell = playGround.getCell(button.getXPos(), button.getYPos());

        if (cell.getCellState() != CellState.EMPTY) {
            String cellValue = viewer.GetTrueCell(cell);
            ImageIcon imageIcon = new ImageIcon(IconGetter.getIcon(cellValue));
            button.setIcon(imageIcon);
            button.setDisabledIcon(imageIcon);
        }
    }
}
