package design_patterns.strategy.duckys;

public class NoQuack implements IQuackBehaviour {
    @Override
    public String quack() {
        return "...";
    }
}
