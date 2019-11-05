package gameHandlers.gameEvents;

public interface GameEventInterface {
    void end(String reason);
    void otherEvent(String message);
    boolean isGameEnded();
    boolean isWin();
    void setWin();
}
