package design_patterns.strategy;

public class Animal {
    private String name;
    private String sound;
    public Flys fly;

    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public Flys getFly() {
        return fly;
    }

    public void canFly(boolean status){
        if(status){
            this.fly = new ItFlys();
        }
        else{
            this.fly = new CantFly();
        }
    }
}
