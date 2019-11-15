package object_orientation.inheritance.interface_methods;

public interface Flyer {
    default public String identifyMyself(){
        return "I am able to fly";
    }
}
