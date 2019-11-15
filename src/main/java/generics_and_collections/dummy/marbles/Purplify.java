package generics_and_collections.dummy.marbles;

import generics_and_collections.dummy.colors.Color;

import java.util.function.UnaryOperator;

public class Purplify implements UnaryOperator<Marble> {
    public Purplify(){
        System.out.println("HEllo world");
    }

    @Override
    public Marble apply(Marble marble) {
        marble.setColour(Color.PURPLE);
        return marble;
    }
}
