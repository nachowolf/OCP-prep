package object_orientation.inheritance.interface_methods;

public class Pegasus extends Horse implements Flyer, Mythical {
    public static void main(String[] args) {
        Pegasus peg = new Pegasus();
        System.out.println(peg.identifyMyself());
    }
}
