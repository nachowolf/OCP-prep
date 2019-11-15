package generics_and_collections.dummy.marbles;

import generics_and_collections.dummy.colors.Color;

import java.util.function.UnaryOperator;

public class ColorShifter implements UnaryOperator<Marble> {

    final Color color;

    public ColorShifter(Color color){
        this.color = color;
    }

    @Override
    public Marble apply(Marble marble) {
        marble.setColour(color);
        return marble;
    }
}
