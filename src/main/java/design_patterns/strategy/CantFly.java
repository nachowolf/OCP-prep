package design_patterns.strategy;

public class CantFly implements Flys {
    @Override
    public String Fly() {
        return "cant fly";
    }
}
