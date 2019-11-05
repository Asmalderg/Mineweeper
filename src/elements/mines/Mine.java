package elements.mines;

import gameHandlers.mineEvents.MineObserver;

public interface Mine {

    void touchMine();

    void addObserver(MineObserver observer);

    MineStatus getStatus();
}
