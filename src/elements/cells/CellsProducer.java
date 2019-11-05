package elements.cells;

public class CellsProducer {
    private final CellsBuilder cellsBuilder;

    public CellsProducer(CellsBuilder cellsBuilder) {
        this.cellsBuilder = cellsBuilder;
    }

    public Cell build(int x, int y) {
        return cellsBuilder.build(x, y);
    }
}
