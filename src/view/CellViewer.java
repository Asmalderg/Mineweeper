package view;

import elements.cells.Cell;

public class CellViewer {
    private static final CellViewer instance = new CellViewer();

    private CellViewer(){}

    public static CellViewer getInstance() {
        return instance;
    }

    public String GetCellView(Cell cell) {
        if (!cell.isDug()) {
            return "[]";
        }
        return GetTrueCell(cell);
    }

    public String GetTrueCell(Cell cell) {
            switch (cell.getCellState()) {
                case DESTROYED: return "DX";
                case MINED: return "X";
                case EMPTY: return "0";
                default: return String.valueOf(cell.getMinesAround());
            }
    }
}
