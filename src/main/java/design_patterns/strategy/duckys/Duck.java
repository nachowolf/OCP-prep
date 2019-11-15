package design_patterns.strategy.duckys;

import java.util.Optional;

public class Duck {
    private Optional<IQuackBehaviour> quack = Optional.empty();
    private Optional<IFlyBehaviour> fly = Optional.empty();
    private String walk = "Waddling";
    private String type;

    public Duck(String type) {
        this.type = type;
    }

    public void quack(){
        System.out.println(quack.get().quack());
    }

    public void addAQuackSound(IQuackBehaviour quack){
        this.quack = Optional.of(quack);
    }

    public void fly(){
        System.out.println(fly.get().fly());
    }

    public void addFlyStyle(IFlyBehaviour fly){
        this.fly = Optional.of(fly);
    }

    public void getType(){
        System.out.printf("I am a %s duck", type);
        System.out.println();
    }

    public void walk(){
        System.out.printf("I am %s now", this.walk);
        System.out.println();
    }


}
