package gameHandlers.mineEvents;

import elements.mines.MineStatus;

public interface MineObserver {
    void updateStatus(MineStatus status);
}
