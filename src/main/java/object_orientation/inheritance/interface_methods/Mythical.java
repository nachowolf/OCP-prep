package object_orientation.inheritance.interface_methods;

public interface Mythical {

    default public String identifyMyself(){
        return "I am a mythical creature";
    }
}
