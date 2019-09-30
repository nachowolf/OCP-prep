package generics_and_collections.aboutCollections.list;


class Marble{
    private String color;

    public Marble(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marble marble = (Marble) o;
        return color.equals(marble.color);
    }

}

public class ListArrayList {
}
