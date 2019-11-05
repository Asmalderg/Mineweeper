package gameCreator;

import elements.cells.Cell;
import elements.cells.CellsProducer;
import elements.cells.SimpleCellBuilder;
import elements.mode.GameMode;
import elements.playground.PlayGround;
import elements.playground.SimplePlayGround;



public class PlaygroundCreator {

    private static final PlaygroundCreator creator = new PlaygroundCreator();

    private PlaygroundCreator() {}

    public static PlaygroundCreator getInstance() {
        return creator;
    }

    public PlayGround createPlayGround(GameMode mode) {
        PlayGround playGround;
        int height = mode.getHeight();
        int width = mode.getWidth();
        Cell[][] cells = new Cell[mode.getHeight()][mode.getWidth()];
        CellsProducer cellsProducer = new CellsProducer(new SimpleCellBuilder());

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = cellsProducer.build(j, i);
            }
        }

        playGround = new SimplePlayGround(width, height, cells);
        return playGround;
    }
}
