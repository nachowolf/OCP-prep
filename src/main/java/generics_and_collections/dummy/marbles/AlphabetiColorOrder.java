package generics_and_collections.dummy.marbles;

import java.util.Comparator;

public class AlphabetiColorOrder implements Comparator<Marble> {
    @Override
    public int compare(Marble o1, Marble o2) {
        return o1.getColor().toString().compareTo(o2.getColor().toString());
    }
}
