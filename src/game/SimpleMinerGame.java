package game;

import elements.cells.Cell;
import elements.cells.cellState.CellState;
import elements.mines.Mine;
import elements.mines.MinesProducer;
import elements.mines.SimpleMineBuilder;
import elements.mode.GameMode;
import elements.playground.PlayGround;
import gameHandlers.gameEvents.GameEventInterface;
import gameHandlers.mineEvents.MineObserver;
import gameHandlers.mineEvents.SimpleMineObserver;
import gameCreator.MinePlanter;
import gameCreator.PlaygroundCreator;
import view.CellViewer;


public class SimpleMinerGame implements MinerGame {

    private final GameEventInterface eventHandler;
    private PlayGround playGround;
    private int freeCells;

    public SimpleMinerGame(GameEventInterface gameEventHandler) {
        this.eventHandler = gameEventHandler;
    }


    @Override
    public PlayGround getPlayGround() {
        return playGround;
    }

    @Override
    public GameEventInterface getHandler() {
        return eventHandler;
    }

    @Override
    public void startNewGame(GameMode mode) {

        /////////////////////////////Create field//////////////////////////////////////
        freeCells = mode.getHeight() * mode.getWidth() - mode.getMinesAmount();
        playGround = PlaygroundCreator.getInstance().createPlayGround(mode);
        ///////////////////////////////////////////////////////////////////////////////

        /////////////////////Create mine  observer and add give it event handler////////
        MineObserver mineObserver = new SimpleMineObserver(eventHandler);
        /////////////////////////////////////////////////////////////////////////////////

        ///////////////////////Create Mines//////////////////////////////////////////////
        int minesAmount = mode.getMinesAmount();

        MinesProducer minesProducer = MinesProducer.getInstance(new SimpleMineBuilder());
        Mine[] mines = new Mine[minesAmount];
        for (int i = 0; i < minesAmount; i++) {
            mines[i] = minesProducer.build();
            mines[i].addObserver(mineObserver);
        }
        //////////////////////////////////////////////////////////////////////

        //////////Plant mines////////////////////////////////////////////////
        MinePlanter.getInstance().plantMinesRandomly(playGround, mines);
        ////////////////////////////////////////////////////////////////////

        //////////////////////Update cells status/////////////////////////////
        for (int i = 0; i < mode.getHeight(); i++) {
            for (int j = 0; j < mode.getWidth(); j++) {
                Cell cell = playGround.getCell(j, i);
                if (cell.isMined()) {
                    for (Cell c : playGround.getCellsAround(j, i)) {
                        if (!c.isMined()) {
                            c.setMinesAround(c.getMinesAround() + 1);
                        }
                    }
                }
            }
        }
        ///////////////////////////////////////////////////////////////////////
        printAllCells();
        printCellsAsIs();
    }

    @Override
    public void digCell(int xPos, int yPos) {
        Cell currentCell = playGround.getCell(xPos, yPos);
        if (!currentCell.isDug()){
            currentCell.digCell();

            if(!currentCell.isMined()) {
                freeCells--;
            }
            if (freeCells == 0) {
                eventHandler.setWin();
                eventHandler.end("Congratulations! You won!");
                return;
            }
            playGround.setDugCells(playGround.getDugCells() + 1);
            if (currentCell.getCellState() == CellState.EMPTY) {
                Cell[] cells = playGround.getCellsAround(xPos, yPos);
                for (Cell cell : cells) {
                    if (!cell.isDug()) {
                        digCell(cell.getXPos(), cell.getYPos());
                    }
                }
            }
        }
        printAllCells();
        printCellsAsIs();
    }
    private void printCellsAsIs() {
        System.out.println("//////////////////////AS IS//////////////////");
        for (int i = 0; i < getPlayGround().getHeight(); i++) {
            for (int j = 0; j < getPlayGround().getWidth(); j++) {
                System.out.print(CellViewer.getInstance().GetCellView(getPlayGround().getCell(j, i)) + " ");
            }
            System.out.println();
        }
        System.out.println("////////////////////////////////////////");
    }

    private void printAllCells() {
        ////////TODO DELETE
        System.out.println("//////////////////////ALL//////////////////");
        for (int i = 0; i < getPlayGround().getHeight(); i++) {
            for (int j = 0; j < getPlayGround().getWidth(); j++) {
                System.out.print(CellViewer.getInstance().GetTrueCell(getPlayGround().getCell(j, i)) + " ");
            }
            System.out.println();
        }
        System.out.println("/////////////////////////");
    }
}
