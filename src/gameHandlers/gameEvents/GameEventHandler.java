package gameHandlers.gameEvents;

public class GameEventHandler implements GameEventInterface {
    private boolean isGameEnded;
    private String status;
    private boolean isWin;

    @Override
    public boolean isWin() {
        return isWin;
    }

    @Override
    public void setWin() {
        isWin = true;
    }

    @Override
    public boolean isGameEnded() {
        return isGameEnded;
    }

    @Override
    public void end(String reason) {
        isGameEnded = true;
        status = reason;
    }

    @Override
    public void otherEvent(String message) {
        status=message;
    }

    public String getStatus() {
        return status;
    }
}
