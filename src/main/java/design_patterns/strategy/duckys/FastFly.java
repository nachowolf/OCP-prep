package design_patterns.strategy.duckys;

public class FastFly implements IFlyBehaviour {
    @Override
    public String fly() {
        return "Flying fast";
    }
}
