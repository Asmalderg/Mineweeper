package gameHandlers.mineEvents;

import elements.mines.MineStatus;
import gameHandlers.gameEvents.GameEventInterface;


public class SimpleMineObserver implements MineObserver {
    private final GameEventInterface game;

    public SimpleMineObserver(GameEventInterface game) {
        this.game = game;
    }

    @Override
    public void updateStatus(MineStatus status) {
        switch (status) {
            case DETONATED:game.end("The mine was detonated! You loose.");break;
            case MISFIRED:game.otherEvent("The mime was misfired! You're the lucky one");break;
        }
    }
}
