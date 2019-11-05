package elements.mode;

public class BeginnerMode implements GameMode {

    private static final BeginnerMode instance = new BeginnerMode();

    private BeginnerMode() {}

    public static BeginnerMode getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "Beginner";
    }

    @Override
    public int getWidth() {
        return 5;
    }

    @Override
    public int getHeight() {
        return 5;
    }

    @Override
    public int getMinesAmount() {
        return 2;
    }
}
