package gameCreator;

import elements.cells.Cell;
import elements.mines.Mine;
import elements.playground.PlayGround;

import java.util.Random;

public class MinePlanter {
    private static final MinePlanter INSTANCE = new MinePlanter();

    private MinePlanter() {
    }

    public static MinePlanter getInstance() {
        return INSTANCE;
    }

    public void plantMinesRandomly(PlayGround pg, Mine[] mines) {
        Random randomGenerator = new Random();
        for (Mine mine : mines) {
            Cell cell;
            int xPos;
            int yPos;
            do {
                xPos = randomGenerator.nextInt(pg.getWidth());
                yPos = randomGenerator.nextInt(pg.getHeight());
                cell = pg.getCell(xPos, yPos);
            } while (cell.isMined());
            cell.setMine(mine);
        }
    }
}
