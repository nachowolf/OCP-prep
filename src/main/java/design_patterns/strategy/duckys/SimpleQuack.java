package design_patterns.strategy.duckys;

public class SimpleQuack implements IQuackBehaviour {
    @Override
    public String quack() {
        return "Quaaacck!";
    }
}
