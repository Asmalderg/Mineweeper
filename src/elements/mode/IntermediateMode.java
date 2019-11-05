package elements.mode;

public class IntermediateMode implements GameMode {

    private static final IntermediateMode instance = new IntermediateMode();

    private IntermediateMode() {}

    public static IntermediateMode getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "Intermediate";
    }

    @Override
    public int getWidth() {
        return 10;
    }

    @Override
    public int getHeight() {
        return 10;
    }

    @Override
    public int getMinesAmount() {
        return 20;
    }

}
