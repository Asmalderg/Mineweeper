package elements.mode;

public class ExpertMode implements GameMode {

    private static final ExpertMode instance = new ExpertMode();

    private ExpertMode() {}

    public static ExpertMode getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "Expert";
    }

    @Override
    public int getWidth() {
        return 16;
    }

    @Override
    public int getHeight() {
        return 16;
    }

    @Override
    public int getMinesAmount() {
        return 30;
    }
}
