package generics_and_collections.dummy.marbles;

import generics_and_collections.dummy.colors.Color;

import java.util.Objects;

public class Marble {
    private Color color;

    public Marble(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColour(Color color){
        this.color = color;
    }

    @Override
    public String toString() {
        return "Marble{" +
                "color='" + color.toString() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marble marble = (Marble) o;
        return color == marble.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
