package elements.mines;

import gameHandlers.mineEvents.MineObserver;

import java.util.ArrayList;
import java.util.List;

public class SimpleMine implements Mine {
    private final List<MineObserver> observers;
    private MineStatus status;

    public SimpleMine() {
        this.observers = new ArrayList<>();
        this.status = MineStatus.CHARGED;
    }

    @Override
    public void addObserver(MineObserver observer) {
        observers.add(observer);
    }

    private void detonate() {
        status = MineStatus.DETONATED;
        for (MineObserver observer : observers) {
            observer.updateStatus(status);
        }
    }

    @Override
    public MineStatus getStatus() {
        return status;
    }

    @Override
    public void touchMine() {
        this.detonate();
    }
}
