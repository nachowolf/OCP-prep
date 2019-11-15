package design_patterns.strategy.duckys;

public class Main {
    public static void main(String[] args) {
        Duck cityDuck = new Duck("City");
        Duck villageDuck = new Duck("village");
        Duck rubberDuck = new Duck ("rubber");

        cityDuck.addAQuackSound(new SimpleQuack());
        villageDuck.addAQuackSound(new CrazyQuack());
        rubberDuck.addAQuackSound(new NoQuack());

        cityDuck.addFlyStyle(new HighFly());
        villageDuck.addFlyStyle(new FastFly());
        rubberDuck.addFlyStyle(new NoFly());

        cityDuck.fly();
        villageDuck.fly();
        rubberDuck.fly();

        cityDuck.quack();
        villageDuck.quack();
        rubberDuck.quack();

    }
}
