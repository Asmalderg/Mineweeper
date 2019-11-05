package elements.cells;

public class SimpleCellBuilder implements CellsBuilder {
    @Override
    public Cell build(int x, int y) {
        return new SimpleCell(x, y);
    }
}
