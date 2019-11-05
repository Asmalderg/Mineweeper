package game;

import elements.mode.GameMode;
import elements.playground.PlayGround;
import gameHandlers.gameEvents.GameEventInterface;

public interface MinerGame {
     void startNewGame(GameMode mode);
     PlayGround getPlayGround();
     void digCell(int xPos, int yPos);
     GameEventInterface getHandler();
}
