package elements.mines;

public class MinesProducer {
    private MinesBuilder currentBuilder;

    private static final MinesProducer instance = new MinesProducer();

    private void setCurrentBuilder(MinesBuilder builder) {
        currentBuilder = builder;
    }

    private MinesProducer() {}

    public static MinesProducer getInstance(MinesBuilder builder) {
         instance.setCurrentBuilder(builder);
         return instance;
    }


    public Mine build() {
        return currentBuilder.buildMine();
    }
}
