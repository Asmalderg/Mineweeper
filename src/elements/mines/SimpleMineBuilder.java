package elements.mines;

public class SimpleMineBuilder implements MinesBuilder {
    @Override
    public Mine buildMine() {
        return new SimpleMine();
    }
}
