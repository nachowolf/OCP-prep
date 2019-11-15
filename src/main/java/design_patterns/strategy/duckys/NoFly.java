package design_patterns.strategy.duckys;

public class NoFly implements IFlyBehaviour {
    @Override
    public String fly() {
        return "...";
    }
}
