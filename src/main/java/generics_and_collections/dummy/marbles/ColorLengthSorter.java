package generics_and_collections.dummy.marbles;

import java.util.Comparator;

public class ColorLengthSorter implements Comparator<Marble> {
    @Override
    public int compare(Marble o1, Marble o2) {
        return o1.getColor().toString().length() > o2.getColor().toString().length() ? o1.getColor().toString().length() * -1: o1.getColor().toString().length() ;
    }
}
