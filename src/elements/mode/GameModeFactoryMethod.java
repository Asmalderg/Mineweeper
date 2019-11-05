package elements.mode;


public class GameModeFactoryMethod {
    private static final GameModeFactoryMethod instance = new GameModeFactoryMethod();

    private GameModeFactoryMethod() {
    }

    public static GameModeFactoryMethod getInstance() {
        return instance;
    }

    public GameMode[] getAllModes() {
        GameMode[] gameModes = new GameMode[3];
        gameModes[0] = BeginnerMode.getInstance();
        gameModes[1] = IntermediateMode.getInstance();
        gameModes[2] = ExpertMode.getInstance();
        return gameModes;
    }
}
